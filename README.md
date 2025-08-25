# Emojify!

Emojify is a simple Android application that showcases your personally chosen daily emoji on your home screen via a Glance App Widget. 
It is of course carefully hand-picked by the universe for you and totally not loaded from a list at random.
For astrology-defying cheaters, it also allows you to manually refresh the emoji displayed on all placed widgets directly from the main app.

## Features

*   **Daily Emoji Widget:** A sleek home screen widget that displays an emoji. Not much else.
*   **Widget Customization:**
    *   Attempts to maintain a square aspect ratio.
    *   Configured for automatic updates approximately every 2 hours (via `updatePeriodMillis`).
*   **In-App Widget Update:** A button within the main application to instantly update the emoji on all placed widgets.

## Project Structure

*   `app/src/main/kotlin/dev/obnx/emojify/`: Main application code.
    *   `data/EmojiRepository.kt`: Responsible for fetching emoji data (currently reads from a local JSON in assets).
    *   `ui/`: Jetpack Compose UI for the main application.
        *   `EmojifyApp.kt`: Main Composable screen with the update button.
    *   `widget/`: Glance App Widget related code.
        *   `DailyEmojiView.kt`: Composable function for the visual representation of the emoji in the widget.
        *   `EmojifyAppWidget.kt`: The `GlanceAppWidget` implementation.
        *   `EmojifyWidgetReceiver.kt`: The `GlanceAppWidgetReceiver`.
        *   `EmojiGlanceStateDefinition.kt`: Manages the state (current emoji) for the widget using DataStore.
*   `app/src/main/res/`: Android resources.
    *   `xml/emojify_widget_info.xml`: AppWidgetProviderInfo configuration for the widget (size, update frequency, etc.).
    *   `layout/`: Includes preview layouts for the widget.
*   `app/src/main/assets/emojis.json`: The JSON file containing the list of emojis.

## How it Works

1.  **Emoji Source:** The `EmojiRepository` reads a list of emojis from `assets/emojis.json`. The `getRandomEmoji()` method selects one from this list.
2.  **Widget Display:**
    *   The `EmojifyAppWidget` uses `EmojiGlanceStateDefinition` to manage its current emoji state.
    *   This state is persisted in Jetpack DataStore (`CURRENT_EMOJI_KEY`).
3.  **Widget Update Mechanisms:**
    *   **Automatic (Periodic):** The `android:updatePeriodMillis` in `emojify_widget_info.xml` tells the Android system to trigger an update for the widget approximately every 2 hours. When this happens, the `EmojifyWidgetReceiver`'s `onUpdate` method is called.
    *   **Manual (In-App):**
        1.  The "Update all placed widgets" button in `EmojifyApp.kt` is clicked.
        2.  A new random emoji is fetched using `EmojiRepository`.
        3.  This new emoji is saved into DataStore via `EmojiGlanceStateDefinition`.
        4.  `EmojifyAppWidget().updateAll(context)` is called.
        5.  This prompts Glance to re-render all instances of the widget. Each widget instance then reads the new emoji from DataStore (via `EmojiGlanceStateDefinition.currentState()`) and updates its display.

## Building and Running

1.  Clone the repository.
2.  Open the project in Android Studio (latest stable version recommended).
3.  Let Gradle sync and download dependencies.
4.  Run the `app` configuration on an Android device or emulator.
5.  After installing, long-press on your home screen, navigate to "Widgets," find "Emojify," and drag it to your home screen.

## Future Enhancements / To-Do

*   [ ] Add widget configuration options (e.g., background color, emoji size).

## Dependencies

*   Jetpack Compose (UI, Material3)
*   Glance (AppWidget, Material3)
*   Jetpack DataStore (Preferences)
*   Kotlin Coroutines

## Contributing

I made this as a fun side project to learn how Android widgets work. No value to be gained.