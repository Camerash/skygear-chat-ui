package com.camerash.skygear.chat.ui.holder

import android.view.View
import com.camerash.skygear.chat.ui.model.MessageStatusStyle
import com.camerash.skygear.chat.ui.model.MessageTimeStyle

class OutgoingTimeMessageView(itemView: View) : BaseTimeMessageView(itemView) {
    override fun textColor(style: MessageTimeStyle): Int {
        return style.outgoingTextColor
    }

    override fun statusTextColor(style: MessageStatusStyle): Int {
        return style.outgoingTextColor
    }
}