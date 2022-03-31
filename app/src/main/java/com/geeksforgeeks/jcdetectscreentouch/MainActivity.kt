package com.geeksforgeeks.jcdetectscreentouch

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Detect Touch Gestures", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    val mContext = LocalContext.current

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        // Creating a Column to detect Press
                        Column(Modifier.fillMaxWidth().height(150.dp).background(Color.Black).pointerInput(key1 = "someStringKey?") {
                                    detectTapGestures(
                                        onPress = { Toast.makeText(mContext, "Press Detected", Toast.LENGTH_SHORT).show() }
                                    )
                                }){
                            Text("OnPress", fontSize = 20.sp, color = Color.White)
                        }

                        // Adding a Space of height 50dp
                        Spacer(modifier = Modifier.height(50.dp))

                        // Creating a Column to detect Long Press
                        Column(Modifier.fillMaxWidth().height(150.dp).background(Color.Black).pointerInput(key1 = "someStringKey?") {
                            detectTapGestures(
                                onLongPress = { Toast.makeText(mContext, "Long Press Detected", Toast.LENGTH_SHORT).show() }
                            )
                        }){
                            Text("OnLongPress", fontSize = 20.sp, color = Color.Green)
                        }

                        // Adding a Space of height 50dp
                        Spacer(modifier = Modifier.height(50.dp))

                        // Creating a Column to detect Tap (when finger press is released)
                        Column(Modifier.fillMaxWidth().height(150.dp).background(Color.Black).pointerInput(key1 = "someStringKey?") {
                            detectTapGestures(
                                onTap = { Toast.makeText(mContext, "Tap Detected", Toast.LENGTH_SHORT).show() }
                            )
                        }){
                            Text("OnTap", fontSize = 20.sp, color = Color.Yellow)
                        }

                        // Adding a Space of height 50dp
                        Spacer(modifier = Modifier.height(50.dp))

                        // Creating a Column to detect Double Tap
                        Column(Modifier.fillMaxWidth().height(150.dp).background(Color.Black).pointerInput(key1 = "someStringKey?") {
                            detectTapGestures(
                                onDoubleTap = { Toast.makeText(mContext, "Double Tap Detected", Toast.LENGTH_SHORT).show() }
                            )
                        }){
                            Text("OnDoubleTap", fontSize = 20.sp, color = Color.Red)
                        }

                    }
                }
            )
        }
    }
}
