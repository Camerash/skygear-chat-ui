package com.camerash.skygear.chat.ui.holder

import android.view.View
import android.widget.TextView
import com.camerash.skygear.R
import com.camerash.skygear.chat.ui.model.Message

class UsernameMessageView(itemView: View) {

    var username: TextView? = null

    init {
        username = itemView.findViewById<TextView>(R.id.usernameText)
    }

    fun onBind(message: Message) {
        username?.let {
            it.text = message.author?.name ?: ""
            it.visibility = if (it.text?.isEmpty() ?: true) View.GONE else View.VISIBLE
        }

        username?.setTextColor(message.style.senderTextColor)
    }
}