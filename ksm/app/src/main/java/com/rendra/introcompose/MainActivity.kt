package com.rendra.introcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rendra.introcompose.ui.theme.IntroComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Text(
//                        text = "Hello World!",
//                        color = Color.Red,
//                        fontStyle = FontStyle.Italic,
//                        fontSize = 30.sp,
//                    )
//                    Button(
//                        onClick = { /*TODO*/ }
//                    ) {
//                        Text(
//                            text = "Click Me",
//                            color = Color.Red,
//                            fontStyle = FontStyle.Italic,
//                            fontSize = 30.sp,
//                        )
//                    }
//                    Image(
//                        modifier = Modifier.size(40.dp),
//                        painter = painterResource(id = R.drawable.ic_favorite),
//                        contentDescription = "Image Favorit"
//                    )
//                    Column {
//                        Text(text = "Text satu")
//                        Button(onClick = { /*TODO*/ }) {}
//                        Text(text = "text 2")
//                    }
//                    Row(
//                        modifier = Modifier
//                                    .background(color = Color.Green)
//                                    .fillMaxWidth()
//                    ) {
//                        Text(text = "Text satu")
//                        Button(onClick = { /*TODO*/ }) {}
//                        Text(text = "text 2")
//                    }
//                    val names = listOf("Prana", "Rendra", "Dwi", "Kurnia")
//
//                    LazyColumn {
//                        items(names.size) { idx ->
//                            Text(names[idx])
//                        }
//                    }
//                    Column {
//                        Text(text = "teks 1")
//                        Spacer(modifier = Modifier.height(30.dp))
//                        Divider(modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(16.dp)
//                                    .absolutePadding(top = 16.dp, bottom = 8.dp)
//                        )
//                        Button(onClick = { /*TODO*/ }) {}
//                    }
//                    Row {
//                        Text(text = "teks 1")
//                        Spacer(modifier = Modifier.width(30.dp))
//                        Button(onClick = { /*TODO*/ }) {}
//                    }
                    Canvas(modifier = Modifier.size(40.dp)) {
                        drawCircle(color = Color.DarkGray)
                    }
                }
            }
        }
    }
}
