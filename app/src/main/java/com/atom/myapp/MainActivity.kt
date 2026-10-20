package com.atom.myapp

import android.R.attr.label
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp
import com.atom.myapp.data.StoreDarkMode
import com.atom.myapp.data.StoreUserMail
import com.atom.myapp.ui.theme.MyAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val darkModeStore = StoreDarkMode(this)
            val darkMode=darkModeStore.getDarkMode.collectAsState(false)
            MyAppTheme (
                darkTheme = darkMode.value
            ){
                Surface(
                    modifier= Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background
                ){
                    Greeting(darkModeStore,darkMode.value)
                }
            }
        }
    }
}

@Composable
fun Greeting(darkModeStore: StoreDarkMode, darkMode:Boolean) {
    val context= LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = StoreUserMail(context)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        var email by rememberSaveable {mutableStateOf("")}
        var userMail = dataStore.getMail.collectAsState(initial = "")
        TextField(
            value= email,
            onValueChange = {email = it},
                label={ Text(text="Email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

        )
        Spacer(modifier=Modifier.height(10.dp))
        Button(onClick = {
            scope.launch {
                dataStore.saveMail(email)
            }
        }) {
            Text(text = "Guardar Email")
        }
        Spacer(modifier=Modifier.height(10.dp))
        Text(userMail.value.toString())
        Spacer(modifier=Modifier.height(16.dp))
        Button(onClick = {
            scope.launch {
                if(darkMode){
                    darkModeStore.saveDarkMode(false)
                }
                else{
                    darkModeStore.saveDarkMode(true)
                }
            }
        }){
            Text("Cambiar a modo oscuro")
        }
    }


}

