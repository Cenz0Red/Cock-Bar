package com.example.cock_bar

import android.graphics.*
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.graphics.RectF
import androidx.core.content.ContextCompat

class Text_n_Image(context: Context, attributeSet: AttributeSet)
    : View(context, attributeSet) {

    private val cornerRadius = 20f
    private var image: Bitmap? = null
    private var text: String = ""
    private var textColor: Int = ContextCompat.getColor(context, android.R.color.black)
    private var textSize: Float = 50f
    private var textAlign: Int = TEXT_ALIGN_CENTER

    private val paint = Paint().apply {
        isAntiAlias = true
        color = textColor
        textSize = this@Text_n_Image.textSize
        textAlign = Paint.Align.CENTER
    }

    init {
        // Загрузка картинки из ресурсов
        image = BitmapFactory.decodeResource(resources, R.drawable.your_image)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        image?.let {
            // Создаем прямоугольник с закругленными углами
            val rectF = RectF(0f, 0f, width.toFloat(), height.toFloat())
            val path = Path().apply {
                addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW)
            }
            canvas.clipPath(path)
            canvas.drawBitmap(it, null, rectF, null)
        }

        // Рисуем текст
        paint.color = textColor
        paint.textSize = textSize

        val xPos = when (textAlign) {
            TEXT_ALIGN_LEFT -> 0f
            TEXT_ALIGN_CENTER -> width / 2f
            TEXT_ALIGN_RIGHT -> width.toFloat()
            else -> width / 2f
        }

        val yPos = (height / 2f - (paint.descent() + paint.ascent()) / 2)

        canvas.drawText(text, xPos, yPos, paint)
    }

    fun setText(text: String) {
        this.text = text
        invalidate()
    }

    fun setTextColor(color: Int) {
        this.textColor = color
        paint.color = color
        invalidate()
    }

    fun setTextSize(size: Float) {
        this.textSize = size
        paint.textSize = size
        invalidate()
    }

    fun setTextAlign(align: Int) {
        this.textAlign = align
        paint.textAlign = when (align) {
            TEXT_ALIGN_LEFT -> Paint.Align.LEFT
            TEXT_ALIGN_CENTER -> Paint.Align.CENTER
            TEXT_ALIGN_RIGHT -> Paint.Align.RIGHT
            else -> Paint.Align.CENTER
        }
        invalidate()
    }

    companion object {
        const val TEXT_ALIGN_LEFT = 0
        const val TEXT_ALIGN_CENTER = 1
        const val TEXT_ALIGN_RIGHT = 2
    }
}


