package com.example.projekt_proba2.data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import java.time.LocalDate


class ItemsRepository (private val itemDao: ItemDao){

    val allItems = MutableLiveData<List<Item>>()
    val foundItem = MutableLiveData<Item>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)




    fun addItem(newItem: Item) {
        coroutineScope.launch(Dispatchers.IO) {
            itemDao.insert(newItem)
        }
    }

    fun updateItemDetails(newItem: Item) {
        coroutineScope.launch(Dispatchers.IO) {
            itemDao.update(newItem)
        }
    }




    fun getItems() : Flow<List<Item>>  {
        return itemDao.getAllItems()
    }

    fun getItemsFromDate(date: Long): Flow<List<Item>> {
        return itemDao.getItemsFromDate(date)
    }



}

