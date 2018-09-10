package com.camerash.skygearchatui.holder

import android.view.View
import com.stfalcon.chatkit.messages.MessageHolders
import com.camerash.skygearchatui.model.ImageMessage

class IncomingImageMessageView(itemView: View) : MessageHolders.IncomingImageMessageViewHolder<ImageMessage>(itemView) {

    var senderAvatarMessageView: SenderAvatarMessageView? = null
    var usernameMessageView: UsernameMessageView? = null
    var timeMessageView: IncomingTimeMessageView? = null
    init {
        usernameMessageView = UsernameMessageView(itemView)
        timeMessageView = IncomingTimeMessageView(itemView)
        senderAvatarMessageView = SenderAvatarMessageView(itemView)
    }

    override fun onBind(message: ImageMessage) {
        super.onBind(message)
        usernameMessageView?.onBind(message)
        timeMessageView?.onBind(message)
        senderAvatarMessageView?.onBind(message)
    }
}
