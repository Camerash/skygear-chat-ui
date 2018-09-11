package com.camerash.skygear.chat.ui.holder

import android.view.View
import com.camerash.skygear.chat.ui.model.Message
import com.camerash.skygear.chatkit.messages.MessageHolders

class OutgoingTextMessageView(itemView: View) : MessageHolders.OutcomingTextMessageViewHolder<Message>(itemView) {

    var timeMessageView: OutgoingTimeMessageView? = null
    var receiverAvatarMessageView: ReceiverAvatarMessageView? = null
    var bubbleView: OutgoingBubbleMessageView? = null

    init {
        receiverAvatarMessageView = ReceiverAvatarMessageView(itemView)
        timeMessageView = OutgoingTimeMessageView(itemView)
        bubbleView = OutgoingBubbleMessageView(itemView)
    }

    override fun onBind(message: Message) {
        super.onBind(message)
        receiverAvatarMessageView?.onBind(message)
        timeMessageView?.onBind(message)
        bubbleView?.onBind(message)
    }
}
