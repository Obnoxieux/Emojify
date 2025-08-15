package dev.obnx.emojify.widget

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle

@Composable
fun DailyEmojiView(emoji: String) {
    Scaffold(
        titleBar = {
            Row(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = GlanceModifier.padding(8.dp)
            ) {
                Text(text = "Your daily emoji")
            }
        }
    ) {
        Column(
            verticalAlignment = Alignment.CenterVertically,
            modifier = GlanceModifier.fillMaxSize()
        ) {
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = emoji,
                    style = TextStyle(fontSize = MaterialTheme.typography.headlineLarge.fontSize)
                )
            }
        }
    }
}
