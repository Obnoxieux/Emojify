package dev.obnx.emojify.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.glance.LocalContext
import androidx.glance.text.Text
import dev.obnx.emojify.data.EmojiRepository

@Composable
fun DailyEmojiView() {
    val context = LocalContext.current
    val repository = remember { EmojiRepository(context) }

    Text(text = repository.getRandomEmoji())
}