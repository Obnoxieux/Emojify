package dev.obnx.emojify.widget

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.provideContent
import androidx.glance.currentState
import androidx.glance.state.GlanceStateDefinition
import dev.obnx.emojify.data.EmojiRepository
import dev.obnx.emojify.ui.theme.EmojifyWidgetGlanceColorScheme

class EmojifyAppWidget : GlanceAppWidget() {
    override val sizeMode = SizeMode.Exact

    companion object {
        val CURRENT_EMOJI = stringPreferencesKey("current_widget_emoji")
    }

    override val stateDefinition: GlanceStateDefinition<Preferences> = EmojiGlanceStateDefinition

    /**
     * This stuff is complex: https://stackoverflow.com/questions/77088363/android-jetpack-glance-1-0-0-problems-updating-widget
     */
    override suspend fun provideGlance(context: Context, id: GlanceId) {

        // In this method, load data needed to render the AppWidget.
        // Use `withContext` to switch to another thread for long running
        // operations.

        val repository = EmojiRepository(context)

        provideContent {
            val emoji = currentState(CURRENT_EMOJI) ?: repository.getRandomEmoji()
            GlanceTheme(colors = EmojifyWidgetGlanceColorScheme.colors) {
                DailyEmojiView(emoji)
            }
        }
    }
}