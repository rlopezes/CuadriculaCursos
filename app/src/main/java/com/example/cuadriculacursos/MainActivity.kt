package com.example.cuadriculacursos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadriculacursos.data.DataSource
import com.example.cuadriculacursos.model.Topic
import com.example.cuadriculacursos.ui.theme.CuadriculaCursosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaCursosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CuadriculaCursosApp()
                }
            }
        }
    }
}

@Composable
fun CuadriculaCursosApp() {
    TopicList(DataSource.topics)
}

@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns= GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier
    ) {
        items(topicList) {topic ->
            TopicCard(
                topic = topic
                //igual que usar contentPadding
                //modifier = Modifier.padding(8.dp)
            )
        }
        /*items(items = topicList,
            itemContent = {topic -> TopicCard(
                topic = topic,
                modifier = Modifier.padding(8.dp))
            }
        )*/
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.descriptionResourceId),
                modifier = Modifier
                    //.size(width = 68.dp, height = 68.dp)
                    .width(68.dp)
                    .height(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier.padding(start=16.dp, top=16.dp, end=16.dp)
            ) {
                Text(
                    text = stringResource(topic.descriptionResourceId),
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row{
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = topic.courses.toString(),

                        //USANDO FICHERO EXTERNO DE DIMENSIONES
                        modifier = Modifier.padding(start=dimensionResource(R.dimen.padding_small)),

                        //SIN USAR FICHERO EXTERNO DE DIMENSIONES
                        //modifier = Modifier.padding(start=8.dp),

                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CuadriculaCursosAppPreview() {
    CuadriculaCursosApp()
    //TopicCard( Topic(R.string.architecture, 58, R.drawable.architecture) )
}