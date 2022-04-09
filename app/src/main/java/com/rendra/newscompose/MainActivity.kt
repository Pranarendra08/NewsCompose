package com.rendra.newscompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.rendra.newscompose.model.News
import com.rendra.newscompose.repository.NewsRepository
import com.rendra.newscompose.ui.theme.NewsComposeTheme
import com.rendra.newscompose.util.DateFormatUtil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val newsList = NewsRepository.getAll()

                    Column {
                        Header()
                        NewsList(newsList = newsList)
                    }
                }
            }
        }
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.width(160.dp),
            painter = rememberAsyncImagePainter("https://static.wikia.nocookie.net/logopedia/images/7/75/Google_News_2015.png/revision/latest?cb=20160220081235"),
            contentDescription = "Logo App",
        )
    }
}

@Composable
fun NewsList(newsList: List<News>) {
    LazyColumn {
        items(newsList.size) {
            // Render News Row
            NewsListItem(newsList[it])

            Divider(
                modifier = Modifier.fillMaxWidth()
                                    .height(1.dp)
                                    .absolutePadding(left = 16.dp, right = 16.dp)
            )
        }
    }
}

@Composable
fun NewsListItem(news: News) {

    val context = LocalContext.current

    Box(
        modifier = Modifier.clickable {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("extra_id", news.id)
            context.startActivity(intent)
        },
    ) {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min).padding(16.dp)
        ) {
            // Left Side - News Info
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                // News Tittle
                Text(
                    text = news.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                )

                // Author & Date
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Author
                    Text(
                        text = news.author,
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
                        text = DateFormatUtil.formatDate(news.date),
                        fontSize = 12.sp
                    )
                }
            }
            
            // Spacer
            Spacer(modifier = Modifier.width(8.dp))
            
            // Right Side - News Image
            Image(
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp)),
                painter = rememberAsyncImagePainter(model = news.imageUrl),
                contentDescription = "News Image",
                contentScale = ContentScale.Crop,
            )
        }
    }
}