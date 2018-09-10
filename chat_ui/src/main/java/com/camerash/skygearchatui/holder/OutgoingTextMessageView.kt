package com.camerash.skygearchatui.holder

import android.view.View
import com.camerash.skygearchatui.model.Message
import com.stfalcon.chatkit.messages.MessageHolders

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
