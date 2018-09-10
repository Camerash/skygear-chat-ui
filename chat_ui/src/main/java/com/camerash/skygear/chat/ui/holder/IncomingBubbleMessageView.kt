package com.camerash.skygear.chat.ui.holder

import android.view.View
import com.camerash.skygear.chat.ui.model.MessageBubbleStyle
import com.stfalcon.chatkit.R

class IncomingBubbleMessageView(itemView: View) : BaseBubbleMessageView(itemView, R.drawable.shape_incoming_message, true) {
    override fun backgroundColor(style: MessageBubbleStyle): Int {
        return style.backgroundColorForIncomingMessages
    }
}
