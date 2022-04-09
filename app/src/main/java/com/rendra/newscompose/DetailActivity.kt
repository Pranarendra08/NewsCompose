package com.rendra.newscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.rendra.newscompose.repository.NewsRepository
import com.rendra.newscompose.ui.theme.NewsComposeTheme
import com.rendra.newscompose.util.DateFormatUtil

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getIntExtra("extra_id", -1)
        val news = NewsRepository.getAll().first { it.id == id }

        setContent {
            NewsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        Modifier.fillMaxHeight()
                    ) {
                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
                            NewsImage(news.imageUrl)
                            NewsTitle(news.title)
                            AuthorAndDate(author = news.author, date = news.date)
                            Description(desc = news.description)
                        }

                        var isFav by remember{mutableStateOf(false)}

                        FloatingActionButton(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(16.dp),
                            onClick = {
                                isFav = !isFav
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = if (isFav)
                                                                    R.drawable.ic_favorite_filled
                                                                else
                                                                    R.drawable.ic_favorite_border
                                ),
                                contentDescription = "Icon Favorit"
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun NewsImage(imageUrl: String) {
    Image(
        modifier = Modifier
            .aspectRatio(16 / 9f)
            .fillMaxWidth(),
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = "",
        contentScale = ContentScale.Crop
    )
}

@Composable
fun NewsTitle(title: String) {
    Text(
        modifier = Modifier.padding(16.dp),
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun AuthorAndDate(author: String, date: String) {
    Row(
        modifier = Modifier.absolutePadding(left = 16.dp, right = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Author
        Text(
            text = author,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.width(4.dp))

        // Canvas Dot
        Canvas(
            modifier = Modifier.size(4.dp)
        ) {
            drawCircle(Color.Gray)
        }

        Spacer(modifier = Modifier.width(4.dp))

        // Date
        Text(
            text = DateFormatUtil.formatDate(date),
            fontSize = 12.sp
        )
    }
}

@Composable
fun Description(desc: String) {
    Text(
        modifier = Modifier.padding(16.dp),
        text = desc
    )
}