package dev.obnx.emojify.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.glance.appwidget.updateAll
import dev.obnx.emojify.data.EmojiService
import dev.obnx.emojify.widget.EmojifyAppWidget
import kotlinx.coroutines.launch

@Composable
fun EmojifyApp() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val emojiService = EmojiService()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Emojify",
                style = MaterialTheme.typography.headlineMedium,
            )
            Text(
                text = "This app does not actually do anything here, go to your home screen and select the widget."
            )
            Button(onClick = {
                scope.launch {
                    emojiService.setNewEmojiPreferenceValue(context)
                    EmojifyAppWidget().updateAll(context)
                }
            }) {
                Text(text = "Update all placed widgets")
            }
            Text(
                text = "This is a cheat button. Learn to live with the universe's choice for today!",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}