package dev.obnx.emojify.data

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset

class EmojiRepository(context: Context) {
    private var emojiList = mutableListOf<String>()

    init {
        try {
            val inputStream = context.assets.open("data-ordered-emoji.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val jsonString = String(buffer, Charset.defaultCharset())
            val jsonArray = JSONArray(jsonString)

            for (i in 0 until jsonArray.length()) {
                emojiList.add(jsonArray.getString(i))
            }

        } catch (ioException: IOException) {
            ioException.printStackTrace()
        } catch (jsonException: JSONException) {
            jsonException.printStackTrace()
        }
    }

    fun getRandomEmoji(): String {
        if (emojiList.isNotEmpty()) {
            val randomIndex = (emojiList.indices).random()
            return emojiList[randomIndex]
        }
        return ""
    }
}
