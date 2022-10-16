package com.vishnumate.gdscbitw.whatsapp.screen.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.vishnumate.gdscbitw.whatsapp.data.local.addChat
import com.vishnumate.gdscbitw.whatsapp.data.model.User
import com.vishnumate.gdscbitw.whatsapp.screen.chat.ui.ChatScreenView
import com.vishnumate.gdscbitw.whatsapp.ui.WhatsAppTheme

@ExperimentalFoundationApi
class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val userName = arguments?.getString("userName") ?: ""
        val userImage = arguments?.getString("userImage") ?: ""

        return ComposeView(requireContext()).apply {
            setContent {
                WhatsAppTheme {
                    ChatScreenView(User(2, userName, userImage), {
                        requireActivity().onBackPressed()
                    }) { message ->
                        if (message.isNotEmpty()) {
                            addChat(message)
                        }
                    }
                }
            }
        }
    }
}