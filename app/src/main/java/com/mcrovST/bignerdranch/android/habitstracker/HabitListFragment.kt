package com.mcrovST.bignerdranch.android.habitstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

private const val TAG = "HabitListFragment"
class HabitListFragment: Fragment() {
    private lateinit var habitRecyclerView: RecyclerView
    private var adapter: HabitAdapter? = null

    private val habitListViewModel: HabitListViewModel by lazy{
        ViewModelProvider(this).get(HabitListViewModel::class.java)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View?{
        val view = inflater.inflate(R.layout.fragment_habits_list, container, false)
        habitRecyclerView = view.findViewById(R.id.habit_recycler_view) as RecyclerView
        habitRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
            }
    private fun updateUI(){
        val habits = habitListViewModel.habits
        adapter = HabitAdapter(habits)
        habitRecyclerView.adapter = adapter
    }

    private inner class HabitHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        private lateinit var habit: Habit

        val titleTextView: TextView = itemView.findViewById(R.id.habit_name)
        val durationTextView: TextView = itemView.findViewById(R.id.habits_duration)

        init{
            itemView.setOnClickListener(this)
        }
        fun bind(habit: Habit){
            this.habit = habit
            titleTextView.text = this.habit.title
            durationTextView.text = TimeGetter.getDate(this.habit.date, Date())
        }

        override fun onClick(view:View){
            Toast.makeText(context, "${habit.title} pressed!!",Toast.LENGTH_SHORT).show()
        }

    }

    private inner class HabitAdapter(var habits: List<Habit>): RecyclerView.Adapter<HabitHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitHolder{
         return HabitHolder(layoutInflater.inflate(R.layout.list_item_habit, parent, false))
        }

        override fun onBindViewHolder(holder: HabitHolder, position: Int){
            val habit = habits[position]
            holder.bind(habit)
        }

        override fun getItemCount(): Int = habits.size

    }

    companion object{
        fun newInstance(): HabitListFragment = HabitListFragment()
    }

    private fun getDate(dateOld: Date, dateNew: Date):String{
        val seconds: Long = (dateNew.getTime()-dateOld.getTime())/1000
        val second: Long = seconds%60
        val minutes: Long = ((seconds/60)%60)
        val hours: Long = (((seconds/60)/60)%24)
        val days: Long = (((seconds/60)/60)/24)%365
        val years: Long = (((seconds/60)/60)/24)/365
        return "$years ??????, $days ????????, $hours ??????????, $minutes ??????????, $second ????????????"
    }
}