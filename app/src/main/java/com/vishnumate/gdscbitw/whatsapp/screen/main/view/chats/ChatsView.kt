package com.vishnumate.gdscbitw.whatsapp.screen.main.view.chats

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vishnumate.gdscbitw.whatsapp.data.local.chatsList
import com.vishnumate.gdscbitw.whatsapp.data.model.User
import com.vishnumate.gdscbitw.whatsapp.util.colorLightGreen

@Composable
fun ChatsView(loadNextScreen: (User) -> Unit) {
    LazyColumnFor(chatsList, modifier = Modifier.background(color = colorLightGreen())) { chat ->
        ChatsItemView(chat, loadNextScreen)
        Divider()
    }
}