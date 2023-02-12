package com.mcrovST.bignerdranch.android.habitstracker

import androidx.lifecycle.ViewModel
import java.util.*

class HabitListViewModel : ViewModel() {
    val habits = mutableListOf<Habit>()

    init {
        for (i in 0..100) {
            val habit = Habit()
            habit.title = "Habit № $i"
            habit.date = Date()
            habits += habit
        }
    }
}