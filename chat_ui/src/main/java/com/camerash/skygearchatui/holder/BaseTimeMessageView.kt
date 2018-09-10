package com.camerash.skygearchatui.holder

import android.view.View
import android.widget.TextView
import com.camerash.skygearchatui.R
import com.camerash.skygearchatui.model.Message
import com.camerash.skygearchatui.model.MessageStatusStyle
import com.camerash.skygearchatui.model.MessageTimeStyle
import com.stfalcon.chatkit.utils.DateFormatter

open class BaseTimeMessageView(itemView: View) {
    var timeTextView: TextView? = null
    var statusTextView: TextView? = null

    init {
        timeTextView = itemView.findViewById<TextView>(R.id.messageTime)
        statusTextView = itemView.findViewById<TextView>(R.id.messageStatus)
    }

    fun onBind(message: Message) {
        timeTextView?.setTextColor(textColor(message.style.timeStyle))
        timeTextView?.text = DateFormatter.format(message.getCreatedAt(), message.style.dateFormat)

        statusTextView?.setTextColor(statusTextColor(message.style.statusStyle))
        statusTextView?.text = message.getStatus()
        statusTextView?.visibility = if (message.style.statusStyle.enabled) View.VISIBLE else View.GONE
    }

    open fun textColor(style: MessageTimeStyle): Int {
        return -1
    }

    open fun statusTextColor(style: MessageStatusStyle): Int {
        return -1
    }
}