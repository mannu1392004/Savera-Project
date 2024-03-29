package com.example.savera.Screens.ChatsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.savera.R
import com.example.savera.ui.theme.ralewayfamilt

@Composable
fun groupChatsScreen(messagebar: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                start = 20.dp,
                end = 20.dp, top = 20.dp, bottom = 20.dp
            ),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {


        Card(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 20.dp)
            .clickable {
                messagebar.navigate(route = "chatscreen/official")
            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(modifier = Modifier.size(60.dp),
                    color = Color.Transparent){
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo1_removebg_preview),
                        contentDescription = "",
                    )
                }
                Column {
                    Text(text = "Savera Official",
                        fontFamily = ralewayfamilt,
                        style= MaterialTheme.typography.headlineSmall)

                    Text(text = "Free Volunteers come to Savera ASAP!")
                }
            }


        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 20.dp)
            .clickable {
                messagebar.navigate(route = "chatscreen/thirdandfour")

            }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(modifier = Modifier.size(60.dp),
                    color = Color.Transparent){
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo1_removebg_preview),
                        contentDescription = "",
                    )
                }
                Column {
                    Text(text = "Savera 3rd and 4th year",
                        fontFamily = ralewayfamilt,
                        style= MaterialTheme.typography.headlineSmall)

                    Text(text = "Free Volunteers come to Savera ASAP!")
                }
            }


        }

        Card(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 20.dp)
            .clickable {
                messagebar.navigate(route = "chatscreen/secondandthird")

            }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(modifier = Modifier.size(60.dp),
                    color = Color.Transparent){
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo1_removebg_preview),
                        contentDescription = "",
                    )
                }
                Column {
                    Text(text = "Savera 2nd and 3rd year",
                        fontFamily = ralewayfamilt,
                        style= MaterialTheme.typography.headlineSmall)

                    Text(text = "Free Volunteers come to Savera ASAP!")
                }
            }


        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 20.dp)
            .clickable {
                messagebar.navigate(route = "chatscreen/firstandsecond")

            }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(modifier = Modifier.size(60.dp),
                    color = Color.Transparent){
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo1_removebg_preview),
                        contentDescription = "",
                    )
                }
                Column {
                    Text(text = "Savera 1st and 2nd year",
                        fontFamily = ralewayfamilt,
                        style= MaterialTheme.typography.headlineSmall)

                    Text(text = "Free Volunteers come to Savera ASAP!")
                }
            }


        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 20.dp)
            .clickable {
                messagebar.navigate(route = "chatscreen/first")

            }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(modifier = Modifier.size(60.dp),
                    color = Color.Transparent){
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo1_removebg_preview),
                        contentDescription = "",
                    )
                }
                Column {
                    Text(text = "Savera 1st year",
                        fontFamily = ralewayfamilt,
                        style= MaterialTheme.typography.headlineSmall)

                    Text(text = "Free Volunteers come to Savera ASAP!")
                }
            }


        }



        Card(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 20.dp)
            .clickable {
                messagebar.navigate(route = "chatscreen/second")

            }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(modifier = Modifier.size(60.dp),
                    color = Color.Transparent){
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo1_removebg_preview),
                        contentDescription = "",
                    )
                }
                Column {
                    Text(text = "Savera 2nd year",
                        fontFamily = ralewayfamilt,
                        style= MaterialTheme.typography.headlineSmall)

                    Text(text = "Free Volunteers come to Savera ASAP!")
                }
            }


        }

        Card(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 20.dp)
            .clickable {
                messagebar.navigate(route = "chatscreen/third")

            }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(modifier = Modifier.size(60.dp),
                    color = Color.Transparent){
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo1_removebg_preview),
                        contentDescription = "",
                    )
                }
                Column {
                    Text(text = "Savera 3rd year",
                        fontFamily = ralewayfamilt,
                        style= MaterialTheme.typography.headlineSmall)

                    Text(text = "Free Volunteers come to Savera ASAP!")
                }
            }


        }


        Card(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 20.dp)
            .clickable {
                messagebar.navigate(route = "chatscreen/fourth")

            }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(modifier = Modifier.size(60.dp),
                    color = Color.Transparent){
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo1_removebg_preview),
                        contentDescription = "",
                    )
                }
                Column {
                    Text(text = "Savera 4th year",
                        fontFamily = ralewayfamilt,
                        style= MaterialTheme.typography.headlineSmall)

                    Text(text = "Free Volunteers come to Savera ASAP!")
                }
            }


        }


    }
}