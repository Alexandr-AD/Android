package com.practicum.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val relatedCourse: Int,
    @DrawableRes val imageRes: Int
)
