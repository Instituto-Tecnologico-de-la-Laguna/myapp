package com.atom.myapp.mvv

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atom.myapp.data.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemViewModel : ViewModel(){
    var resultState by mutableStateOf("")
        private set

    var itemList = mutableStateListOf(ItemsModel())
        private set

    var cargando by mutableStateOf(false)
        private set

    init{
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch {
            try{
                cargando=true
                LlamarAPI()
            }
            catch(e: Exception){
                println("Error: ${e.message}")
            }
            finally {
                cargando=false
            }
        }
    }

    private suspend fun LlamarAPI(){
        val result= withContext(Dispatchers.IO){
            delay(5000)
            listOf(
                ItemsModel(1, "Elemento 1"), ItemsModel(2, "Elemento 2"), ItemsModel(3, "Elemento 3"), ItemsModel(4, "Elemento 4"), ItemsModel(5, "Elemento 5"),
                ItemsModel(6, "Elemento 6"), ItemsModel(7, "Elemento 7"), ItemsModel(8, "Elemento 8"), ItemsModel(9, "Elemento 9"), ItemsModel(10, "Elemento 10"),
                ItemsModel(11, "Elemento 11"), ItemsModel(12, "Elemento 12"), ItemsModel(13, "Elemento 13"), ItemsModel(14, "Elemento 14"), ItemsModel(15, "Elemento 15"),
                ItemsModel(16, "Elemento 16"), ItemsModel(17, "Elemento 17"), ItemsModel(18, "Elemento 18"), ItemsModel(19, "Elemento 19"), ItemsModel(20, "Elemento 20"),
                ItemsModel(21, "Elemento 21"), ItemsModel(22, "Elemento 22"), ItemsModel(23, "Elemento 23"), ItemsModel(24, "Elemento 24"), ItemsModel(25, "Elemento 25"),
                ItemsModel(26, "Elemento 26"), ItemsModel(27, "Elemento 27"), ItemsModel(28, "Elemento 28"), ItemsModel(29, "Elemento 29"), ItemsModel(30, "Elemento 30"),
                ItemsModel(31, "Elemento 31"), ItemsModel(32, "Elemento 32"), ItemsModel(33, "Elemento 33"), ItemsModel(34, "Elemento 34"), ItemsModel(35, "Elemento 35"),
                ItemsModel(36, "Elemento 36"), ItemsModel(37, "Elemento 37"), ItemsModel(38, "Elemento 38"), ItemsModel(39, "Elemento 39"), ItemsModel(40, "Elemento 40"),
                ItemsModel(41, "Elemento 41"), ItemsModel(42, "Elemento 42"), ItemsModel(43, "Elemento 43"), ItemsModel(44, "Elemento 44"), ItemsModel(45, "Elemento 45"),
                ItemsModel(46, "Elemento 46"), ItemsModel(47, "Elemento 47"), ItemsModel(48, "Elemento 48"), ItemsModel(49, "Elemento 49"), ItemsModel(50, "Elemento 50")
            )
        }
        itemList.addAll(result)
    }
}