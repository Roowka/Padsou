package com.example.padsou.classes

import android.content.Context
import android.util.DisplayMetrics
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.padsou.ui.theme.colorBox1

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

        fun getColor(color:String) : Color{
            return when (color) {
                "605DF5" -> return Color(0xFF605DF5)
                "F4696A" -> Color(0xFFF4696A)
                "579BFE" ->Color(0xFF579BFE)
                "7C8CF9" ->Color(0xFF7C8CF9)
                else -> {return Color.White}
            }
        }
    }
}