package com.camerash.skygearchatui.holder

import android.view.View
import com.stfalcon.chatkit.messages.MessageHolders
import com.camerash.skygearchatui.model.Message

class IncomingTextMessageView(itemView: View) : MessageHolders.IncomingTextMessageViewHolder<Message>(itemView) {

    var senderAvatarMessageView: SenderAvatarMessageView? = null
    var usernameMessageView: UsernameMessageView? = null
    var timeMessageView: IncomingTimeMessageView? = null
    var bubbleView: IncomingBubbleMessageView? = null

    init {
        usernameMessageView = UsernameMessageView(itemView)
        senderAvatarMessageView = SenderAvatarMessageView(itemView)
        timeMessageView = IncomingTimeMessageView(itemView)
        bubbleView = IncomingBubbleMessageView(itemView)
    }

    override fun onBind(message: Message) {
        bubble?.isSelected = isSelected
        text?.text = message.text

        usernameMessageView?.onBind(message)
        senderAvatarMessageView?.onBind(message)
        timeMessageView?.onBind(message)
        bubbleView?.onBind(message)
    }
}
