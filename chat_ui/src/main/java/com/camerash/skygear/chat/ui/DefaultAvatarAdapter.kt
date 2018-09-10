package com.camerash.skygear.chat.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.camerash.skygear.R
import com.camerash.skygear.chat.ui.model.Message
import com.camerash.skygear.chat.ui.model.User
import io.skygear.plugins.chat.Conversation

open class DefaultAvatarAdapter() : AvatarAdapter() {
    override fun createAvatarView(inflater: LayoutInflater, viewGroup: ViewGroup): View {
        val imageView = inflater.inflate(R.layout.default_avatar_view, viewGroup, false)
        return imageView
    }

    override fun bind(view: View, conversation: Conversation?, message: Message, user: User?) {
        val avatarView = view as DefaultAvatarView
        avatarView.onBind(message)
    }
}