package com.example.padsou.classes

import android.content.Context
import android.util.DisplayMetrics
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class Utils {
    companion object Factory {
        @Composable
        fun PxToDp(pixels: Float): Float {
            val screenPixelDensity = getContext().resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT
            return pixels / screenPixelDensity
        }

        @Composable
        fun getContext(): Context {
            return LocalContext.current
        }
    }
}