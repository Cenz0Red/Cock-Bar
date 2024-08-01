package com.example.cock_bar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Text_n_Image(context: Context, attributeSet: AttributeSet)
    : View(context, attributeSet) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPicture()
    }
}

private fun Any.drawPicture() {
    TODO("Not yet implemented")
}
