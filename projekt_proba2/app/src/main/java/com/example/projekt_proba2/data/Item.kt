package com.example.projekt_proba2.data

import java.util.Date
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val date: Long, //timestamp as example 1705708800000
    var brekafast: Int,
    var lunch: Int,
    var dinner: Int

)
