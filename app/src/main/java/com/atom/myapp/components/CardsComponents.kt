package com.atom.myapp.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TwoCards(title1:String,number1:Double,title2:String,number2:Double){
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly){
        //MainCard()
    }
}

@Composable
fun MainCard(title:String,number:Double,modifier:Modifier=Modifier){
    Card(modifier = modifier

    ){}
}