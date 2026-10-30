package com.example.optimization

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream

object ImageOptimizer {

    /**
     * Compresses a bitmap to reduce its memory footprint and file size.
     * @param bitmap The original bitmap.
     * @param quality The compression quality (0-100). Use 80-85 for WebP.
     * @return The compressed bitmap.
     */
    fun compressBitmap(bitmap: Bitmap, quality: Int = 80): Bitmap {
        val outputStream = ByteArrayOutputStream()
        // WebP is highly recommended over PNG/JPEG for Android
        bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSY, quality, outputStream)
        val byteArray = outputStream.toByteArray()
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }

    /**
     * Loads a bitmap with a reduced sample size to save memory for large images.
     * @param context The context.
     * @param resId The image resource ID.
     * @param reqWidth The required width.
     * @param reqHeight The required height.
     * @return The optimized bitmap or null.
     */
    fun decodeSampledBitmap(context: Context, resId: Int, reqWidth: Int, reqHeight: Int): Bitmap? {
        return BitmapFactory.Options().run {
            inJustDecodeBounds = true
            BitmapFactory.decodeResource(context.resources, resId, this)
            inSampleSize = calculateInSampleSize(this, reqWidth, reqHeight)
            inJustDecodeBounds = false
            BitmapFactory.decodeResource(context.resources, resId, this)
        }
    }

    private fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        var inSampleSize = 1
        if (height > reqHeight || width > reqWidth) {
            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }
}
