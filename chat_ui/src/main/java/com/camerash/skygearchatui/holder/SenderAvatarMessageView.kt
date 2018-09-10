package com.camerash.skygearchatui.holder

import android.view.View
import android.widget.LinearLayout
import com.camerash.skygearchatui.R
import com.camerash.skygearchatui.model.Message

class SenderAvatarMessageView(itemView: View) {

    var avatarView: LinearLayout? = null

    init {
        avatarView = itemView.findViewById<LinearLayout>(R.id.userAvatar)
    }

    fun onBind(message: Message) {
        avatarView?.visibility = if (message.style.hideOutgoing) View.GONE else View.VISIBLE
    }
}
