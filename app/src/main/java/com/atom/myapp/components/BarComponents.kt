package com.atom.myapp.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(name: String){
    Text(name,fontSize=25.sp,color=Color.White)
}

@Composable
fun ActionButton(){
    FloatingActionButton(
        onClick = {},
        containerColor = Color.Red,
        contentColor=Color.White
    ){

    }
}

@Composable
fun MainIconButton(icon: ImageVector, onClick:() -> Unit){
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White)
    }
}