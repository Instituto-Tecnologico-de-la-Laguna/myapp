package com.atom.myapp.modelView

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoteriaViewModel: ViewModel(){
    private val _loteriaNumbers = mutableStateOf(emptyList<Int>())
    val loteriaNumbers : State<List<Int>> = _loteriaNumbers

    fun generadorNumeros(){
        _loteriaNumbers.value = (1..60).shuffled().take(6).sorted()
    }
}