package com.camerash.skygear.chat.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.camerash.skygear.chat.ui.model.Message
import com.camerash.skygear.chat.ui.model.User
import io.skygear.plugins.chat.Conversation
import java.io.Serializable

open class AvatarAdapter : Serializable {
    open fun createAvatarView(inflater: LayoutInflater, viewGroup: ViewGroup): View? { return null }
    open fun bind(view: View, conversation: Conversation?, message: Message, user: User?) {}
}
