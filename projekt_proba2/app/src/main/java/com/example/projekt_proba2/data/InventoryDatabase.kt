package com.example.projekt_proba2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.projekt_proba2.data.Item
import com.example.projekt_proba2.data.ItemDao
import com.example.projekt_proba2.data.Converters

@Database(entities = [Item::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
            @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {

                // coś krzyczy na InventoryDatabase::class.java
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database_V2")
                    .allowMainThreadQueries() //evil shit DO NOT TOUCH OR APP WILL NOT WORK
                    .build()
                    .also { Instance = it }
            }
        }
    }
}



