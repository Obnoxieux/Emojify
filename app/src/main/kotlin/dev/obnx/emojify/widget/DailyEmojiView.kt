package dev.obnx.emojify.widget

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.text.Text
import androidx.glance.text.TextStyle

@Composable
fun DailyEmojiView(emoji: String) {
    Scaffold(
        backgroundColor = GlanceTheme.colors.primaryContainer,
        titleBar = {
            Row(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = GlanceModifier.padding(8.dp).fillMaxWidth()
            ) {
                Text(
                    text = "Your daily emoji",
                    style = TextStyle(
                        color = GlanceTheme.colors.onPrimaryContainer,
                    )
                )
            }
        }
    ) {
        Column(
            verticalAlignment = Alignment.CenterVertically,
            modifier = GlanceModifier.fillMaxSize()
        ) {
            Row(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = GlanceModifier.fillMaxWidth()
            ) {
                Text(
                    text = emoji,
                    style = TextStyle(fontSize = MaterialTheme.typography.displayMedium.fontSize),
                    modifier = GlanceModifier.padding(bottom = 12.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 200, heightDp = 150)
@Composable
fun DailyEmojiViewPreview() {
    DailyEmojiView(emoji = "😀")
}