package com.atom.myapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.atom.myapp.components.MainButton
import com.atom.myapp.components.Space
import com.atom.myapp.components.TitleBar
import com.atom.myapp.components.TitleView



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") //Esta instruccion ayuda a no enviar padding en el uso del Scaffold
@OptIn(ExperimentalMaterial3Api::class) //Se egrega para el CenterAlignedTopAppBar no marque error
@Composable
fun HomeView(navController: NavController)
{
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("Home View") },
                colors= TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {

        }
    ) {
        ContentHomeView(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController) {
    val id = 123
    var opcional by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home View")
        Space()
        TextField(
            value = opcional,
            onValueChange = { opcional = it },
            label = { Text(text = "Opcional") }
        )
        MainButton(name = "Detail view", backColor = Color.Red, color = Color.White) {
            navController.navigate("Detail/${id}/?${opcional}")
        }
    }
}