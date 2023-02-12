package com.mcrovST.bignerdranch.android.habitstracker

import java.util.*

class TimeGetter {
    companion object {
        fun getDate(dateOld: Date, dateNew: Date): String {
            val seconds: Long = (dateNew.getTime() - dateOld.getTime()) / 1000
            val second: Long = seconds % 60
            val minutes: Long = ((seconds / 60) % 60)
            val hours: Long = (((seconds / 60) / 60) % 24)
            val days: Long = (((seconds / 60) / 60) / 24) % 365
            val years: Long = (((seconds / 60) / 60) / 24) / 365
            if (years.toInt() == 0 && days.toInt() == 0 && hours.toInt() == 0 && minutes.toInt() == 0) {
                return "секунды: $second"
            } else if (years.toInt() == 0 && days.toInt() == 0 && hours.toInt() == 0) {
                return "секунды: $second; минуты: $minutes"
            } else if (years.toInt() == 0 && days.toInt() == 0) {
                return "секунды: $second; минуты: $minutes; часы: $hours"
            } else if (years.toInt() == 0) {
                return "секунды: $second; минуты: $minutes; часы: $hours; дни: $days"
            } else {
                return "секунды: $second; минуты: $minutes; часы: $hours; дни: $days; года: $years"
            }
        }
    }
}