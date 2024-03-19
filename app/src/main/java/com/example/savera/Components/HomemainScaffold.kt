package com.example.savera.Components

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import com.example.savera.R
import com.example.savera.Screens.homeScreen.HomeScreenViewModel
import com.example.savera.ui.theme.ralewaybold
import com.example.savera.ui.theme.ralewayfamilt
import com.google.firebase.auth.FirebaseAuth
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainContent(savedPosition: MutableState<Float>, homeScreenViewModel: HomeScreenViewModel) {
    val openUrlLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { }

val gmail = FirebaseAuth.getInstance().currentUser?.email?.split("@")?.get(0)

    val localDate = remember {
        LocalDate.now()
    }
    val localTime = remember {
        LocalTime.now()
    }

    val formateddate  = remember(localDate) {
        localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    }

    val formattime = remember(localTime) {
        localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss a"))
    }



    val context  = LocalContext.current

    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(start = 10.dp, end = 10.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),

        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)


                .shadow(elevation = 20.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                ),

        ) {
            Text(
                text = "Documentary",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                   fontFamily = ralewaybold,
                    color = MaterialTheme.typography.headlineMedium.color
                ),                    modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 13.dp, start = 13.dp)
            )
            Spacer(modifier = Modifier.height(0.dp))

      MyApp(savedPosition)

        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .shadow(elevation = 20.dp)
        ) {
            Text(
                text = "About Savera",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                  fontFamily = ralewaybold,
                    color = MaterialTheme.typography.headlineMedium.color
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Savera School is an evening school in DCRUST Murthal run by Student volunteers to educate the underprivileged section of the society.",
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = ralewayfamilt,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp)
            )
            Spacer(modifier = Modifier.height(9.dp)) // Add some space between heading and text

            Button(onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffF57F17),
                    contentColor = Color.White),
                modifier = Modifier.padding(9.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Know More",
                    fontFamily = ralewayfamilt)
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .shadow(elevation = 20.dp)
        ) {
            Text(
                text = "Any idea or suggestions",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontFamily = ralewaybold,
                    color = MaterialTheme.typography.headlineMedium.color
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 13.dp, top = 15.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor =  Color.Black,
                    focusedLabelColor =  Color.Transparent,
                    unfocusedLabelColor =  Color.Transparent,
                    containerColor = Color.White
                ),


                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xffF57F17),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .clip(
                        RoundedCornerShape(15.dp)
                    )

                ,
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Type your ideas here!",
                    fontFamily = ralewayfamilt,
                    color =Color(0xff33333380)
                )
                }

            )
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Button(onClick = {

                        homeScreenViewModel.addFeedback(
                            collectionName = "Feedback",
                            documentPath = gmail.toString(),
                            data = hashMapOf(
                                "$formateddate $formattime" to text
                            ),
                            error = {
                                Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
                            }
                            ,
                            Successfull = {
                                Toast.makeText(context, "Sent to Admin", Toast.LENGTH_SHORT).show()
                                text=  ""
                            }
                        )

                },
                    colors = ButtonColors(containerColor = Color(0xffF57F17),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent
                        )
                    , shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(bottom = 10.dp)
                    ) {
                    Text(text = "Submit", fontFamily = ralewayfamilt,)
                }

            }


        }
        // soical media part
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .shadow(elevation = 10.dp)
        ) {
            Column (modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)){
                Text(text = "Connect With Us", fontFamily = ralewayfamilt,
                    modifier = Modifier.padding(top = 30.dp))
                Row {

                    Image(painter = painterResource(id = R.drawable.img), contentDescription = "",
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(painter = painterResource(id = R.drawable.img_1), contentDescription = ""
                    , modifier = Modifier.clickable {

                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/saveraschool/"))
                            openUrlLauncher.launch(intent)

                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(painter = painterResource(id = R.drawable.img_9), contentDescription = "",
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@SaveraSchool"))
                            openUrlLauncher.launch(intent)
                        })
                }

                Spacer(modifier = Modifier.height(30.dp))
            }




            }
        Spacer(modifier = Modifier.height(1.dp))
        }
    }


@Composable
fun MyApp(savedPosition: MutableState<Float>) {
    val youtubeVideoId = rememberSaveable { mutableStateOf("z8cqhEywCzc") }
    val lifecycleOwner = LocalLifecycleOwner.current

    YouTubePlayer(youtubeVideoId = youtubeVideoId.value, lifecycleOwner = lifecycleOwner,savedPosition)
}

@Composable
fun YouTubePlayer(
    youtubeVideoId: String,
    lifecycleOwner: LifecycleOwner,
    savedPosition: MutableState<Float>
) {
    val savedState = rememberSaveable { mutableStateOf(youtubeVideoId) }


    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = { context ->

            YouTubePlayerView(context = context).apply {
                lifecycleOwner.lifecycle.addObserver(this)

                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {

                            youTubePlayer.loadVideo(savedState.value, savedPosition.value)
                            youTubePlayer.setVolume(0)

                    }
                    override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {

                        savedPosition.value = second

                    }
                })
            }
        }
    )
}


