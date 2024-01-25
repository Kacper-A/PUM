package com.example.projekt_proba2.data
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Delete
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate


@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<Item>>

    @Query("SELECT * FROM items WHERE date = :date")
    fun getItemsFromDate(date: Long): Flow<List<Item>>


    @Query("SELECT COUNT() FROM items WHERE date = :date")
    fun countInDate(date: Long): Int

    @Query("SELECT * FROM items WHERE date = :date") //there should only be UP to 1 item in database with given date
    fun getItemFromDateDirectly(date: Long): Item

    @Query("delete from items")
    fun deleteAll()
}