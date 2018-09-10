package com.camerash.skygearchatui.holder

import android.view.View
import android.widget.TextView
import com.camerash.skygearchatui.R
import com.camerash.skygearchatui.model.Message

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