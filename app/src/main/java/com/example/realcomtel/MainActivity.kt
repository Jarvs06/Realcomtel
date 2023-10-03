package com.example.realcomtel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.example.realcomtel.ui.theme.RealcomtelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealcomtelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Reaela()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reaela(){

    val postList = remember {
        mutableStateListOf<UserPost>()
    }

    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))
    postList.add(UserPost("Charles Gorre", "Mahal na mahal si Reaela!"))

    Scaffold { padding ->
        LazyColumn(
            contentPadding = PaddingValues(10.dp)
        ){
            postList.forEach{item ->
                item{
                    RecycleviewItem(name = item.Name, description = item.Description)
                }
            }
        }
    }
}

@Composable
fun RecycleviewItem(name:String, description:String) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://images.pexels.com/photos/18129003/pexels-photo-18129003/free-photo-of-portrait-of-a-bearded-senior-man-in-grey-shawl-and-cap.jpeg")
                        .transformations(CircleCropTransformation())
                        .size(Size(120, 120))
                        .build(),
                    contentDescription = "null")
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            AsyncImage(
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(RoundedCornerShape(50f)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://images.pexels.com/photos/18129003/pexels-photo-18129003/free-photo-of-portrait-of-a-bearded-senior-man-in-grey-shawl-and-cap.jpeg")
                    .build(),
                contentDescription = "null")

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Send, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "")
                }
            }

            Text(text = description)
        }
    }
    Spacer(modifier = Modifier.size(10.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RealcomtelTheme {

    }
}