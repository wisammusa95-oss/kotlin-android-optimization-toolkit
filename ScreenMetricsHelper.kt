package com.example.optimization

import android.content.Context
import android.util.DisplayMetrics

object ScreenMetricsHelper {

    /**
     * Converts density-independent pixels (dp) to pixels (px).
     */
    fun dpToPx(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    /**
     * Converts pixels (px) to density-independent pixels (dp).
     */
    fun pxToDp(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.density
    }

    /**
     * Retrieves the current screen density category (e.g., xhdpi, xxhdpi).
     * Useful for loading optimized assets based on the device's screen.
     */
    fun getScreenDensity(context: Context): String {
        return when (context.resources.displayMetrics.densityDpi) {
            DisplayMetrics.DENSITY_LOW -> "ldpi"
            DisplayMetrics.DENSITY_MEDIUM -> "mdpi"
            DisplayMetrics.DENSITY_HIGH -> "hdpi"
            DisplayMetrics.DENSITY_XHIGH -> "xhdpi"
            DisplayMetrics.DENSITY_XXHIGH -> "xxhdpi"
            DisplayMetrics.DENSITY_XXXHIGH -> "xxxhdpi"
            else -> "unknown"
        }
    }
}
