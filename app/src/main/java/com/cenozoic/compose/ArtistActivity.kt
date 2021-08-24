package com.cenozoic.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.BoxWithConstraintsScope as BoxWithConstraintsScope1

class ArtistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     setContent {
         MatchParentSizeComposable()
//          ArtistCard(artist = Artist("artist","3 minutes ago"),{})
     }
    }

    data class Artist(val name:String,val lastSeenOnline:String)
    @Composable
    fun ArtistCard(artist: Artist, onClick:()-> Unit) {
//        modifier = Modifier.size(width = 500.dp,height = 300.dp
        Surface() {
            val padding = 16.dp
            Column(
                Modifier
                    /*.clickable(onClick = onClick)*/
                    .padding(padding)
                    .background(color = Color.Cyan)
                    .fillMaxWidth()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_launcher_background),contentDescription = null)
                    Column {
                        Text(artist.name)
                        Text(artist.lastSeenOnline,modifier = Modifier.offset(x = 10.dp))
                    }
                }
                Spacer(modifier = Modifier.size(padding))
                Card() {
                    
                }
            }

        }

    }
    
    @Preview
    @Composable
    fun DefaultArtist(){
        ArtistCard(artist = Artist("artist","3 minutes ago"),{

        })
    }

    /**
     * MatchParentSize
     */
    @Preview
    @Composable
    fun MatchParentSizeComposable(){
        Box() {
            Spacer(modifier = Modifier
                .matchParentSize()
                .background(Color.LightGray))
            Artist(artist = Artist("artist","3 minutes ago look book? haha"))
        }
    }

    @Composable
    fun Artist(artist: Artist){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null)
            Column {
                Text(artist.name)
                Text(artist.lastSeenOnline,)//modifier = Modifier.offset(x = 10.dp)
            }
        }
    }

    /**
     * Weight
     */
    @Preview
    @Composable
    fun WeightComposable(){
        ArtistCard(artist = Artist("artist","3 minutes ago look book? haha"))
    }
    @Composable
    fun ArtistCard(artist: Artist) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),contentDescription = null,
                modifier = Modifier.weight(2f)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(artist.name)
                Text(artist.lastSeenOnline,)
            }
        }
    }
    @Preview
    @Composable
    fun WithConstraintsComposable() {
//        BoxWithConstraints(content = {
//            Text("My minHeight is $minHeight while my maxWidth is $maxWidth")
//        })
        BoxWithConstraints(content = {
            Text("My minHeight is $minHeight while my maxWidth is $maxWidth")
        }
        )
    }


}