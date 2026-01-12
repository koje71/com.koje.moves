package com.koje.framework.graphics

import android.opengl.GLES20
import android.opengl.GLES20.GL_BLEND
import android.opengl.GLES20.GL_COLOR_BUFFER_BIT
import android.opengl.GLES20.GL_DEPTH_BUFFER_BIT
import android.opengl.GLES20.GL_DEPTH_TEST
import android.opengl.GLES20.GL_LEQUAL
import android.opengl.GLES20.GL_ONE_MINUS_SRC_ALPHA
import android.opengl.GLES20.GL_SRC_ALPHA
import android.opengl.GLES20.glBlendFunc
import android.opengl.GLES20.glClear
import android.opengl.GLES20.glClearColor
import android.opengl.GLES20.glDepthFunc
import android.opengl.GLES20.glEnable
import android.opengl.GLES20.glReadPixels
import android.opengl.GLES20.glViewport
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import android.view.MotionEvent
import android.view.View
import com.koje.framework.events.IntNotifier
import com.koje.framework.utils.Logger
import java.nio.ByteBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10


open class Surface : GLSurfaceView.Renderer, View.OnTouchListener {

    open var minRatio = 1.4f
    var active = true

    val drawers = mutableListOf<Drawer>()
    val picmap = createImageDrawer()
    val components = ComponentGroup(this)

    var loopTime = 0
    var loopStart = 0L
    var height = 0
    var width = 0
    var ratio = 0f

    var fpsCount = IntNotifier(0)
    var fpsCounter = 0
    var fpsTimer = 0

    var imageCount = IntNotifier(0)
    var imageCounter = 0

    var lastClickX = 0f
    var lastClickY = 0f

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        glClearColor(0f, 0f, 0f, 0.0f)
    }

    open fun createContent(target: ComponentGroup) {

    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        this.height = height
        this.width = width

        loopTime = 0
        loopStart = 0L
        glViewport(0, 0, width, height)
        ratio = height.toFloat() / width.toFloat()
        glEnable(GL_DEPTH_TEST)
        glEnable(GL_BLEND)
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
        glDepthFunc(GL_LEQUAL)
        Logger.info(this, "ratio: $ratio")
        if (ratio >= minRatio) {
            Matrix.orthoM(
                components.matrix,
                0,
                -0.5f,
                0.5f,
                -ratio / 2f,
                ratio / 2f,
                -10f,
                10f
            )
        } else {
            Matrix.orthoM(
                components.matrix,
                0,
                -0.5f * (minRatio / ratio),
                0.5f * (minRatio / ratio),
                minRatio / 2 * -1,
                minRatio / 2,
                -10f,
                10f
            )
        }

        drawers.forEach {
            it.init()
        }

    }

    override fun onDrawFrame(gl: GL10?) {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)

        val currentTime = System.currentTimeMillis()
        imageCounter = 0
        if (loopStart > 0) {
            if (active) {
                components.draw()
            }
            loopTime = (currentTime - loopStart).toInt()
            updateCounters()
        }
        loopStart = currentTime

        if (touchX * touchY != 0) {
            val ss = ByteBuffer.allocate(4)
            glReadPixels(
                touchX,
                touchY,
                1,
                1,
                GLES20.GL_RGBA,
                GLES20.GL_UNSIGNED_BYTE,
                ss
            )
            Logger.info(this, "r-color ${ss[0]}")
            Logger.info(this, "g-color ${ss[1]}")
            Logger.info(this, "b-color ${ss[2]}")
            Logger.info(this, "a-color ${ss[3]}")
            Logger.info(this, "images ${imageCounter}")

            touchX = 0
            touchY = 0
        }

    }

    fun updateCounters() {
        fpsTimer += loopTime
        fpsCounter++
        if (fpsTimer >= 1000) {
            fpsCount.set(fpsCounter)
            fpsTimer = 0
            fpsCounter = 0
            imageCount.set(imageCounter)
        }
    }

    private fun createImageDrawer(action: ImageDrawer.() -> Unit = {}): ImageDrawer {
        val result = ImageDrawer()
        action.invoke(result)

        drawers.add(result)
        return result
    }

    var touchX = 0
    var touchY = 0

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (event != null) {
            lastClickX = event.x
            lastClickY = event.y

            var posX = (event.x - width / 2) / width
            var posY = (-event.y + height / 2) / width

            if (ratio < minRatio) {
                posX *= minRatio / ratio
                posY *= minRatio / ratio
            }
            onTouch(Position(posX, posY), event)

            touchX = event.x.toInt()
            touchY = event.y.toInt()
        }
        return true
    }

    open fun onTouch(position: Position, event: MotionEvent) {
    }

    fun addComponent(member: Component) {
        components.addComponent(member)
    }

}