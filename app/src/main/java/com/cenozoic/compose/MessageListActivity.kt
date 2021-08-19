package com.cenozoic.compose

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cenozoic.compose.ui.theme.ComposeTheme

class MessageListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Conversation(messages = list)
//                MessageCard(msg = Message("Android", "Jetpack Compose"))
            }
        }
    }

    data class Message(val author: String, val body: String)

    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Contact profile picture", modifier = Modifier
                    .size(40.dp)
                    .clip(
                        CircleShape
                    )
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            var isExpanded by remember{
                mutableStateOf(false)
            }
            val surfaceColor by animateColorAsState(if (isExpanded)
                MaterialTheme.colors.primary else MaterialTheme.colors.surface)
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier.animateContentSize().padding(1.dp)
                ) {
                    Text(
                        text = msg.body,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(all =4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,

                    )
                }
            }

        }


    }

    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        MessageCard(msg = Message("Colleague", "Hey, take a look at Jetpack Compose,it's great"))
    }


    /**
     * 列表
     */
    @Composable
    fun Conversation(messages: List<Message>){
        LazyColumn(){
            items(messages){  
                item: Message ->
                MessageCard(msg = item)
            }
        }
    }
   val list = mutableListOf<Message>(Message("Colleague",
       "Hey, take a look at Jetpack Compose,it's great"),Message("Colleague",
       "Hey, take a look at Jetpack Compose,it's great.现在，我们可以根据 isExpanded 更改点击消息时的消息内容的背景。" +
               "我们将使用 clickable 修饰符来处理可组合项上的点击事件"))
   @Preview
   @Composable
   fun PreviewConversation(){
       ComposeTheme() {
           Conversation(messages = list)
       }
   }
    
    
}


