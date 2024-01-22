package com.example.lista5.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreOcena(private val context: Context) {

    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("Oceny")
        val OCENY_KEY = stringPreferencesKey("przedmiot")
    }

    val getOcena: Flow<String?> = context.dataStore.data.map { preferences-> preferences[OCENY_KEY]?:"" }

    suspend fun saveOcena(przedmiot:String)
    {
        context.dataStore.edit { preferences->preferences[OCENY_KEY] = przedmiot }
    }
}