package com.camerash.skygearchatui.holder

import android.view.View
import com.camerash.skygearchatui.model.MessageStatusStyle
import com.camerash.skygearchatui.model.MessageTimeStyle

class IncomingTimeMessageView(itemView: View) : BaseTimeMessageView(itemView) {
    override fun textColor(style: MessageTimeStyle): Int {
        return style.incomingTextColor
    }

    override fun statusTextColor(style: MessageStatusStyle): Int {
        return style.incomingTextColor
    }
}