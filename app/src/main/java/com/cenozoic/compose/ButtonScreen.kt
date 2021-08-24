package com.cenozoic.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.res.painterResource

class ButtonScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TopAppBar(title = {
                Text(text = "Page title", maxLines = 2)
            }, navigationIcon = {
                Icon(painter = painterResource(id = R.drawable.icon_shua),
                contentDescription = "icon")}
            )
//            Button(onClick = { /*TODO*/ }) {
//
//            }
        }
    }

}