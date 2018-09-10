package com.camerash.skygear.chat.ui.model

import android.net.Uri
import io.skygear.plugins.chat.Message as ChatMessage

class MessageFactory {
    companion object {
        fun getMessage(m: ChatMessage, style: MessageStyle, uri: Uri? = null, orientation: Int? = null): Message {
            return m.asset?.mimeType.let {
                when {
                    it?.startsWith("image") == true -> ImageMessage(m, uri, orientation, style)
                    it?.equals(VoiceMessage.MIME_TYPE) == true -> VoiceMessage(m, style, uri)
                    else -> Message(m, style)
                }
            }
        }
    }
}
