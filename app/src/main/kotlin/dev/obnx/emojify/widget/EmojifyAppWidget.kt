package dev.obnx.emojify.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import dev.obnx.emojify.data.EmojiRepository

class EmojifyAppWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {

        // In this method, load data needed to render the AppWidget.
        // Use `withContext` to switch to another thread for long running
        // operations.

        val repository = EmojiRepository(context)
        val emoji = repository.getRandomEmoji()

        provideContent {
            DailyEmojiView(emoji)
        }
    }
}