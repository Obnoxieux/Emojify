package dev.obnx.emojify.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.glance.text.Text
import dev.obnx.emojify.data.EmojiRepository

@Composable
fun DailyEmojiView() {
    val repository = remember { EmojiRepository() }

    Text("Hello Banana!")
}