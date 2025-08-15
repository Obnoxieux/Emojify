package dev.obnx.emojify.widget

import androidx.compose.runtime.Composable
import androidx.glance.text.Text

@Composable
fun DailyEmojiView(emoji: String) {
    Text(text = emoji)
}