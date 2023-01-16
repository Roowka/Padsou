package com.example.padsou.classes

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class Utils {
    @Composable
    fun PxToDp(pixels : Float) : Float{
        val screenPixelDensity = getContext().resources.displayMetrics.density
        return pixels / screenPixelDensity
    }

    @Composable
    fun getContext(): Context {
        return LocalContext.current
    }
}