package com.atom.myapp.onBoardViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonFinish(currentPage:Int){
    Row(
        modifier= Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
        ){
        if(currentPage==1){
            OutlinedButton(onClick = { /*TODO*/ },){
                Text("Entrar", modifier=Modifier
                    .padding(horizontal = 8.dp, vertical = 40.dp),
                    color=Color.Gray)
            }
        }
    }

}