package com.camerash.skygearchatui.holder

import android.view.View
import com.camerash.skygearchatui.model.MessageBubbleStyle
import com.stfalcon.chatkit.R

class IncomingBubbleMessageView(itemView: View) : BaseBubbleMessageView(itemView, R.drawable.shape_incoming_message, true) {
    override fun backgroundColor(style: MessageBubbleStyle): Int {
        return style.backgroundColorForIncomingMessages
    }
}
