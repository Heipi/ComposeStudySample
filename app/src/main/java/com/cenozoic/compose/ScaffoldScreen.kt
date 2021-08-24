package com.cenozoic.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ScaffoldScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            HomeScreen()
        }
    }
    @Composable
    fun HomeScreen(){
        Scaffold(drawerContent ={
            Text(text = "JJ")
            Text(text = "HH")
        },topBar = {Text(text = "II")},content = {
           Text(text = "KK")
        })
    }

    @Preview
    @Composable
    fun PreviewHomeScreen(){
        HomeScreen()
    }
}