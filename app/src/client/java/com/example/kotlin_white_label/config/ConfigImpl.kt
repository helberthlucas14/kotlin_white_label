package com.example.kotlin_white_label.config

import android.view.View
import javax.inject.Inject

class ConfigImpl @Inject constructor() : Config {
    override val addButtonVisibility: Int = View.GONE
}