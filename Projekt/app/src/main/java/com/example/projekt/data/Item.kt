package com.example.projekt.data

import java.util.Date
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: Date,
    val brekafast: Int,
    val lunch: Int,
    val dinner: Int

)
