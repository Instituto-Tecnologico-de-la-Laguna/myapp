package com.atom.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atom.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Formulario()
                }
            }
        }
    }
}
@Composable
fun Formulario(){
    Column(
        modifier= Modifier
            .fillMaxWidth()
            .padding(96.dp),
         verticalArrangement =
             Arrangement.spacedBy(12.dp),
        horizontalAlignment=
            Alignment.CenterHorizontally
    ){
        Text("Titulo",fontSize=56.sp)
        Text("Subtitulo",fontSize=34.sp)
        Button(onClick = {}) {
            Text("Ingresar", fontWeight = FontWeight.Bold)
        }
    }
}