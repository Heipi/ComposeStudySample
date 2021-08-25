package com.cenozoic.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class ScaffoldScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HomeScreen()
//            ScaffoldCodelab()
//            LayoutsCodelab()
            LayoutsTopBarCodelab()

        }
    }


    @Composable
    fun LayoutsTopBarCodelab() {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(
                    text = "LayoutsCodelab",
                )
                
            },actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            })

        }) {
            BodyContent(Modifier.padding(it))
        }

    }


    @Composable
    fun LayoutsCodelab() {
        Scaffold(topBar = {
            Text(
                text = "LayoutsCodelab",
                style = MaterialTheme.typography.h3
            )
        }) {
            BodyContent(Modifier.padding(it))
        }

    }

    @Composable
    fun BodyContent(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            Text(text = "Hi there!")
            Text(text = "Thanks for going through the Layouts codelab")
        }
    }

    @Preview
    @Composable
    fun ScaffoldCodelab() {
        Scaffold() {
            Column(modifier = Modifier.padding(it)) {
                Text(
                    text = "Hi there!",
                    modifier = Modifier.padding(paddingValues = it)
                )
                Text(text = "Thanks for going through the Layouts codelab")
            }
        }

    }


    @Composable
    fun HomeScreen() {
        Scaffold(drawerContent = {
            Text(text = "JJ")
            Text(text = "HH")
        }, topBar = { Text(text = "II") }, content = {
            Text(text = "KK")
        })
    }

    @Preview
    @Composable
    fun PreviewHomeScreen() {
        HomeScreen()
    }
}