package io.skygear.plugins.chat.ui.holder

import android.view.View
import com.stfalcon.chatkit.R
import io.skygear.plugins.chat.ui.model.MessageBubbleStyle

class IncomingBubbleMessageView(itemView: View) : BaseBubbleMessageView(itemView, R.drawable.shape_incoming_message, true) {
    override fun backgroundColor(style: MessageBubbleStyle): Int {
        return style.backgroundColorForIncomingMessages
    }
}
