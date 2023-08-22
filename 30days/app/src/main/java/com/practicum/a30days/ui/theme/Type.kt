package com.practicum.a30days.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.practicum.a30days.R

val Caveat = FontFamily(
    Font(R.font.caveat_regular),
    Font(R.font.caveat_medium, FontWeight.Medium),
    Font(R.font.caveat_semibold, FontWeight.SemiBold),
    Font(R.font.caveat_bold, FontWeight.Bold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Caveat,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = Caveat,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Caveat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Caveat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

