package com.practicum.a30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.practicum.a30days.R

data class Day(
    val numOfDay: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)

val days = listOf(

//    Day(R.string.day_1, R.string.title_1, R.string.desc_1, R.drawable.ex_1 ),
//    Day(R.string.day_2, R.string.title_2, R.string.desc_2, R.drawable.ex_2 ),
//    Day(R.string.day_3, R.string.title_3, R.string.desc_3, R.drawable.ex_3 ),
//    Day(R.string.day_4, R.string.title_4, R.string.desc_4, R.drawable.ex_4 ),
//    Day(R.string.day_5, R.string.title_5, R.string.desc_5, R.drawable.ex_5 ),
//    Day(R.string.day_6, R.string.title_6, R.string.desc_6, R.drawable.ex_6 ),
//    Day(R.string.day_7, R.string.title_7, R.string.desc_7, R.drawable.ex_7 ),
//    Day(R.string.day_8, R.string.title_8, R.string.desc_8, R.drawable.ex_8 ),
//    Day(R.string.day_9, R.string.title_9, R.string.desc_9, R.drawable.ex_9 ),
//    Day(R.string.day_10, R.string.title_10, R.string.desc_10, R.drawable.ex_10 ),
//    Day(R.string.day_11, R.string.title_11, R.string.desc_11, R.drawable.ex_11 )
    Day(1, R.string.title_1, R.string.desc_1, R.drawable.ex_1 ),
    Day(2, R.string.title_2, R.string.desc_2, R.drawable.ex_2 ),
    Day(3, R.string.title_3, R.string.desc_3, R.drawable.ex_3 ),
    Day(4, R.string.title_4, R.string.desc_4, R.drawable.ex_4 ),
    Day(5, R.string.title_5, R.string.desc_5, R.drawable.ex_5 ),
    Day(6, R.string.title_6, R.string.desc_6, R.drawable.ex_6 ),
    Day(7, R.string.title_7, R.string.desc_7, R.drawable.ex_7 ),
    Day(8, R.string.title_8, R.string.desc_8, R.drawable.ex_8 ),
    Day(9, R.string.title_9, R.string.desc_9, R.drawable.ex_9 ),
    Day(10, R.string.title_10, R.string.desc_10, R.drawable.ex_10 ),
    Day(11, R.string.title_11, R.string.desc_11, R.drawable.ex_11 )
)