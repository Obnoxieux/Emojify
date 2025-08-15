package dev.obnx.emojify.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import dev.obnx.emojify.widget.EmojifyAppWidget
import dev.obnx.emojify.widget.emojiDataStore

class EmojiService {
    suspend fun setNewEmojiPreferenceValue(context: Context) {
        val repository = EmojiRepository(context)
        val newEmoji = repository.getRandomEmoji()

        context.emojiDataStore.edit { preferences ->
            preferences[EmojifyAppWidget.CURRENT_EMOJI] = newEmoji
        }
    }
}