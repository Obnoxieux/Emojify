package dev.obnx.emojify.widget

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.glance.state.GlanceStateDefinition
import java.io.File

val Context.emojiDataStore: DataStore<Preferences> by preferencesDataStore(name = "emojify_widget_prefs")

object EmojiGlanceStateDefinition : GlanceStateDefinition<Preferences> {

    override suspend fun getDataStore(context: Context, fileKey: String): DataStore<Preferences> {
        return context.emojiDataStore
    }

    override fun getLocation(
        context: Context,
        fileKey: String
    ): File {
        TODO("Not yet implemented")
    }
}