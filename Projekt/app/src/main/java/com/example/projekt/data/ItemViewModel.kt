package com.example.projekt.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ItemViewModel @Inject constructor(private val itemsRepository: ItemsRepository) :
    ViewModel(){

    val itemList: LiveData<List<Item>> = itemsRepository.allItems

    val foundItem: LiveData<Item> = itemsRepository.foundItem

    fun addItem(item: Item) {
        itemsRepository.addItem(item)
        //getAllItems() //prawdopodobnie do aktualizacji danych albo czegoś
    }
    fun updateItem(item:Item)
    {
        itemsRepository.updateItemDetails(item)
        //getAllItems()
    }

}


