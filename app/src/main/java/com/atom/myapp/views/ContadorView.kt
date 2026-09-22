package com.atom.myapp.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.atom.myapp.modelView.ContadorViewModel


@Composable
fun ContadorView(view : ContadorViewModel){
    Box(
        contentAlignment= Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = view.contador.value.toString(),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold)
    }
}