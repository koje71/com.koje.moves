package com.koje.framework.view

import android.opengl.GLSurfaceView
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import com.koje.moves.R
import kotlin.math.min
import kotlin.math.roundToInt


open class ViewGroupBuilder(override val view: ViewGroup) :
    ViewBuilder(view) {

    fun addClickBackground(default: Int, clicket: Int) {

    }

    fun addCheckbox(action: CheckboxBuilder.() -> Unit) {
        val result = CheckBox(view.context)
        view.addView(result)
        CheckboxBuilder(result).action()
    }

    fun addWebView(action: WebViewBuilder.() -> Unit) {
        val result = WebView(view.context)
        view.addView(result)
        WebViewBuilder(result).action()
    }

    fun addRadioButton(action: RadioButtonBuilder.() -> Unit) {
        val result = RadioButton(view.context)
        view.addView(result)
        RadioButtonBuilder(result).action()
    }

    fun addSeekBar(action: SeekBarBuilder.() -> Unit) {
        val result = SeekBar(view.context)
        view.addView(result)
        SeekBarBuilder(result).action()
    }

    fun addFrameLayout(action: FrameLayoutBuilder.() -> Unit) {
        val result = FrameLayout(view.context)
        view.addView(result)
        FrameLayoutBuilder(result).action()
    }

    fun addImageView(action: ImageViewBuilder.() -> Unit) {
        val result = ImageView(view.context)
        view.addView(result)
        ImageViewBuilder(result).action()
    }

    fun addHorizontalScrollView(action: HorizontalScrollViewBuilder.() -> Unit) {
        val result = HorizontalScrollView(view.context)
        view.addView(result)
        HorizontalScrollViewBuilder(result).action()
    }


    fun addLinearLayout(action: LinearLayoutBuilder.() -> Unit) {
        val result = LinearLayout(view.context)
        view.addView(result)
        LinearLayoutBuilder(result).action()
    }

    fun addExtendedLinearLayout(action: ExtendedLinearLayoutBuilder.() -> Unit) {
        val result = NewLinearLayout(view.context)
        view.addView(result)
        ExtendedLinearLayoutBuilder(result).action()
    }

    fun addRelativeLayout(action: RelativeLayoutBuilder.() -> Unit) {
        val result = RelativeLayout(view.context)
        view.addView(result)
        RelativeLayoutBuilder(result).action()
    }

    fun addTextView(action: TextViewBuilder.() -> Unit) {
        val result = TextView(view.context)
        view.addView(result)
        TextViewBuilder(result).action()
    }

    fun addOutlineTextView(action: OutlineTextViewBuilder.() -> Unit) {
        val result = OutlineTextView(
            view.context,
            getColorFromID(R.color.white),
            2f,
        )
        view.addView(result)
        OutlineTextViewBuilder(result).action()
    }

    fun addScrollView(action: ScrollViewBuilder.() -> Unit) {
        val result = ScrollView(view.context)
        view.addView(result)
        ScrollViewBuilder(result).action()
    }

    fun addSwitch(action: SwitchBuilder.() -> Unit) {
        val result = Switch(view.context)
        view.addView(result)
        SwitchBuilder(result).action()
    }

    fun addFixedRatioLayout(ratio: Float, maxHeightDP: Int, action: FrameLayoutBuilder.() -> Unit) {
        val result = object : FrameLayout(view.context) {
            override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
                val width = MeasureSpec.getSize(widthMeasureSpec)
                val height = min(getPixelFromDP(maxHeightDP), (width * ratio).roundToInt())
                val newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
                super.onMeasure(widthMeasureSpec, newHeightMeasureSpec)
            }
        }
        view.addView(result)
        FrameLayoutBuilder(result).action()
    }

    fun addSurfaceView(action: SurfaceViewBuilder.() -> Unit) {
        val result = GLSurfaceView(view.context)
        view.addView(result)
        SurfaceViewBuilder(result).action()
    }

    fun addView(action: ViewBuilder.() -> Unit) {
        val result = View(view.context)
        view.addView(result)
        ViewBuilder(result).action()
    }

    fun removeAllViews() {
        view.removeAllViews()
    }
}