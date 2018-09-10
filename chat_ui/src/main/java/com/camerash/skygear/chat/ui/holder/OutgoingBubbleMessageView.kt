package com.camerash.skygear.chat.ui.holder

import android.view.View
import com.camerash.skygear.chat.ui.model.MessageBubbleStyle
import com.stfalcon.chatkit.R

class OutgoingBubbleMessageView(itemView: View) : BaseBubbleMessageView(itemView, R.drawable.shape_outcoming_message, false) {
    override fun backgroundColor(style: MessageBubbleStyle): Int {
        return style.backgroundColorForOutgoingMessages
    }
}