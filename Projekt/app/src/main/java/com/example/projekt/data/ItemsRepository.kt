package com.example.projekt.data
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


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
}

