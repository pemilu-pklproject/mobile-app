package com.metromatika.sipemilu.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

class DataStoreRepository(context: Context) {

    private object PreferencesKey {
        val selectedRoleKey = stringPreferencesKey(name = "selected_role")
    }

    private val dataStore = context.dataStore

    suspend fun saveSelectedRole(role: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.selectedRoleKey] = role
        }
    }

    fun readSelectedRole(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[PreferencesKey.selectedRoleKey] ?: ""
            }
    }
}
