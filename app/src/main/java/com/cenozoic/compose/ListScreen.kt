package com.cenozoic.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

class ListScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            SimpleList()
//            LazyList()
//            ImageList()
            ScrollingList()
        }
    }

    /**
     * SIMPLE LIST
     * Column
     */
    @Composable
    fun SimpleList() {
        // We save the scrolling position with this state that can also
        // be used to programmatically scroll the list
        val scrollState = rememberScrollState()
        Column(Modifier.verticalScroll(scrollState)) {
            repeat(100) {
                Text("Item #$it")
            }
        }
    }

    /**
     * LazyColumn
     * 仅呈现屏幕上可见的项目，允许性能提高，不需要滚动修饰符
     */

    @Composable
    fun LazyList() {
        val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {
            items(100) {
                Text(text = "Item #$it")
            }
        }
    }

    @Composable
    fun ImageList() {
        val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {
            items(100) {
                ImageListItem(it)
            }
        }
    }
//https://img0.baidu.com/it/u=2507552753,546211921&fm=26&fmt=auto&gp=0.jpg
    @Composable
    fun ImageListItem(index: Int) {
    Column(Modifier
        .padding(horizontal = 10.dp)) {
        Row(modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp),
            verticalAlignment = Alignment.Top) {
            Image(
                painter = rememberImagePainter(data = "https://img0.baidu.com/it/u=2507552753,546211921&fm=26&fmt=auto&gp=0.jpg"),
                contentDescription = "List Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .height(height = 100.dp),
                alignment = Alignment.CenterStart

            )
            Spacer(modifier = Modifier.width(10.dp))
            Text("Item #$index", style = MaterialTheme.typography.subtitle1)
        }
        Divider(Modifier.height(2.dp))
    }

    }

    @Composable
    fun ScrollingList() {
        val listSize = 100
        //  We save the scrolling position with this state
        val scrollState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        Column() {
            Row() {
                Button(onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }) {
                    Text(text = "Scroll to the top")
                }

                Button(onClick = { coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                } }) {
                   Text(text = "Scroll to the end")
                }
            }
            LazyColumn(state = scrollState){
                items(listSize){
                    ImageListItem(index = it)
                }
            }


        }


    }


}