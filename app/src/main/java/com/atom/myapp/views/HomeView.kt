package com.atom.myapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.atom.myapp.components.Alert
import com.atom.myapp.components.MainButton
import com.atom.myapp.components.MainTextField
import com.atom.myapp.components.SpaceH
import com.atom.myapp.components.TwoCards
import com.atom.myapp.viewModel.CalcularViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeView( viewModel:CalcularViewModel){
    Scaffold(
        topBar={
            CenterAlignedTopAppBar(
                title={Text(text="App Descuentos",
                    color=Color.White
                )},
                colors= TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ){
        ContentHomeView(it,viewModel)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues,viewModel: CalcularViewModel){
    Column(
        modifier=Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val state=viewModel.state

        TwoCards(
            title1="Total",
            number1=state.totalDescuento,
            title2="Descuento",
            number2=state.precioDescuento
        )
        MainTextField(value=state.precio, onValueChange =
            {viewModel.onValue(it,"precio")},label="Precio")
        SpaceH()
        MainTextField(value=state.descuento, onValueChange =
            {viewModel.onValue(it,"descuento")},label="Descuento")
        SpaceH(10.dp)
        MainButton("Generar Descuento") {
            viewModel.calcular()
        }
        SpaceH()
        MainButton("Limpiar") {
            viewModel.limpiar()
        }
        if(state.showAlert){
            Alert(title="Alerta",
                message = "Escribe el precio y descuento",
                confirmText = "Aceptar",
                { viewModel.cancelAlert()}) { }
        }


    }
}