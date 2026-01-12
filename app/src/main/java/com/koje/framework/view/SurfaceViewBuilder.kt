package com.koje.framework.view

import android.graphics.PixelFormat
import android.opengl.GLSurfaceView
import com.koje.framework.graphics.Surface


class SurfaceViewBuilder(override val view: GLSurfaceView) :
    ViewBuilder(view) {

    init {
        view.setEGLContextClientVersion(2)
    }

    interface Editor : ViewEditor<SurfaceViewBuilder>

    fun setSurface(surface: Surface) {
        setSurface(surface, true)
    }

    fun setSurface(surface: Surface, transparence: Boolean) {
        with(view) {
            setZOrderOnTop(transparence)
            setEGLConfigChooser(8, 8, 8, 8, 16, 0)
            holder.setFormat(PixelFormat.RGBA_8888)
            setRenderer(surface)
            //           renderMode = GLSurfaceView.RENDERMODE_WHEN_DIRTY
            setOnTouchListener(surface)
        }
    }

}