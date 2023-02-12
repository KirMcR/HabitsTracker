package com.mcrovST.bignerdranch.android.habitstracker

import java.util.*

data class Habit (
    var id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date()
)