package com.example.projekt_proba2.data


import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import java.time.LocalDate

class ItemViewModel(application: Application) : ViewModel() {
    private val repository: ItemsRepository

    var _itemsState = MutableStateFlow<List<Item>>(emptyList())
    val usersState: StateFlow<List<Item>>
        get() = _itemsState

    private var _itemsFromDateState = MutableStateFlow<List<Item>>(emptyList())
    val itemsFromDateState: StateFlow<List<Item>>
        get() = _itemsFromDateState


    init {
        val db = InventoryDatabase.getDatabase(application)
        val dao = db.itemDao()
        repository = ItemsRepository(dao)

        fetchItems()


    }

    private fun fetchItems() {
        println("didfetch")
        viewModelScope.launch {

            println("inScopeLaunchValue"+repository.countInDate(1705881600000))


                //_itemsState.value = items

        }
        println("test fetchItems(): "+_itemsState.value)
    }

    fun addItem(item: Item)
    {
        viewModelScope.launch {
            repository.addItem(item)
        }
    }

    fun checkIfItemExists(date: Long): Boolean {
        return repository.countInDate(date)>0
    }

    fun fetchItemsFromDate(date: Long) {
        viewModelScope.launch {
            repository.getItemsFromDate(date).collect { items ->
                _itemsFromDateState.value = items
            }
        }
    }



    fun updateItemDetails(item: Item) {
        viewModelScope.launch {
            repository.updateItemDetails(item)
        }
    }

    fun getItemFromDateDirectly(date: Long): Item{
        return repository.getItemFromDateDirectly(date)
    }

    fun deleteAll()
    {
        repository.deleteAll()
    }

}