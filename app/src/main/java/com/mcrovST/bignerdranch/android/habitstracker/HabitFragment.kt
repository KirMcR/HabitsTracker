package com.mcrovST.bignerdranch.android.habitstracker

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import org.w3c.dom.Text
import java.time.Duration
import java.time.temporal.ChronoUnit
import java.util.*

class HabitFragment: Fragment() {
    private lateinit var habit: Habit
    private lateinit var habitTitle: TextView
    private lateinit var habitDuration: TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        habit = Habit()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.fragment_habit_info,container, false)
        habitTitle = view.findViewById(R.id.habit_title) as TextView
        habitDuration = view.findViewById(R.id.duration_of_habit) as TextView
        val tDate = Date()
        habitDuration.apply{
            text = TimeGetter.getDate(habit.date, tDate)
        }
        return view
    }
    private fun getDate(dateOld: Date, dateNew:Date):String{
        val seconds: Long = (dateNew.getTime()-dateOld.getTime())/1000
        val second: Long = seconds%60
        val minutes: Long = ((seconds/60)%60)
        val hours: Long = (((seconds/60)/60)%24)
        val days: Long = (((seconds/60)/60)/24)%365
        val years: Long = (((seconds/60)/60)/24)/365
        return "Прошло $years лет, $days дней, $hours часов, $minutes минут, $second секунд"
    }
}