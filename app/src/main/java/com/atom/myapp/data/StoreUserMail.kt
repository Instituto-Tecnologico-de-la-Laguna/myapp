package com.atom.myapp.data
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserMail(private val context: Context) {
        companion object {
            private val Context.dataStore: DataStore<Preferences>
                    by preferencesDataStore("User_Mail")
            val USER_MAIL = stringPreferencesKey("user_mail")
        }
        val getMail: Flow<String?> = context.dataStore.data
            .map { preferences ->
                preferences[USER_MAIL] ?: ""
            }
    suspend fun saveMail(email:String){
        context.dataStore.edit { preferences ->
            preferences[USER_MAIL] = email
        }
    }
}
