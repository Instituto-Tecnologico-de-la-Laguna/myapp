package com.atom.myapp

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                    Forma()
                }
            }
        }
    }
}

@Composable
fun Forma(){
    Column(
        modifier=Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment=
            Alignment.CenterHorizontally

    ){
        Text("Bienvenido",
            color=Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            textAlign= TextAlign.Center,
            modifier=Modifier
                .background(Color.Black)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()

        )
        Spacer(modifier=Modifier.height(10.dp))
        Text("Jetpack")
        Spacer(modifier=Modifier.height(10.dp))
        Text("Compose")
        LazyRow(  contentPadding = PaddingValues(8.dp)){
            items(){

            }
        }
    }
}
