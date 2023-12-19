package com.example.cuadriculacursos.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val descriptionResourceId: Int,
    val courses: Int,
    @DrawableRes val imageResourceId: Int
)
