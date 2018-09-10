package com.camerash.skygearchatui.holder

import android.view.View
import com.camerash.skygearchatui.model.MessageStatusStyle
import com.camerash.skygearchatui.model.MessageTimeStyle

class OutgoingTimeMessageView(itemView: View) : BaseTimeMessageView(itemView) {
    override fun textColor(style: MessageTimeStyle): Int {
        return style.outgoingTextColor
    }

    override fun statusTextColor(style: MessageStatusStyle): Int {
        return style.outgoingTextColor
    }
}