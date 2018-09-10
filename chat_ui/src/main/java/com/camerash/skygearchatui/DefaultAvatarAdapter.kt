package com.camerash.skygearchatui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.camerash.skygearchatui.model.Message
import com.camerash.skygearchatui.model.User
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