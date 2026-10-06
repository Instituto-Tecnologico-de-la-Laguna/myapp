package com.atom.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atom.myapp.ui.theme.MyAppTheme
import com.atom.myapp.viewModel.CalcularViewModel
import com.atom.myapp.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CalcularViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Surface(
                    modifier= Modifier
                        .fillMaxSize(),
                    color= MaterialTheme.colorScheme.background
                ){
                    HomeView(viewModel)
                }
            }
        }
    }
}
