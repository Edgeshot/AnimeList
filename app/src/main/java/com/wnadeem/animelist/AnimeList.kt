package com.wnadeem.animelist

import android.app.Application

class AnimeList: Application() {


        companion object {
            private lateinit var instance: AnimeList

            const val SHOW_MESSAGE_AT_START = "show_message_at_start"
            const val SHOW_MESSAGE_AT_START1 = "check_box_preference_1"
            const val SHOW_MESSAGE_AT_START2 = "check_box_preference_2"
            const val SHOW_NOW_IMAGE = "show_now_image"
            const val EFFECT_SELECTION = "effect_selection"
        }

        override fun onCreate() {
            instance = this
            super.onCreate()
        }

    }