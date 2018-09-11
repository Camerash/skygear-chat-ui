package com.camerash.skygear.chat.ui.holder

import android.view.View
import com.camerash.skygear.chat.ui.model.VoiceMessage
import com.camerash.skygear.chatkit.messages.MessageHolders

class OutgoingVoiceMessageView(view: View) : MessageHolders.OutcomingTextMessageViewHolder<VoiceMessage>(view) {
    var voiceMessageView: VoiceMessageView? = null
    var receiverAvatarMessageView: ReceiverAvatarMessageView? = null
    var timeMessageView: OutgoingTimeMessageView? = null
    var bubbleView: OutgoingBubbleMessageView? = null

    init {
        voiceMessageView = VoiceMessageView(itemView, false)
        timeMessageView = OutgoingTimeMessageView(itemView)
        receiverAvatarMessageView = ReceiverAvatarMessageView(itemView)
        bubbleView = OutgoingBubbleMessageView(itemView)
    }

    override fun onBind(message: VoiceMessage) {
        super.onBind(message)
        voiceMessageView?.onBind(message)
        receiverAvatarMessageView?.onBind(message)
        timeMessageView?.onBind(message)
        bubbleView?.onBind(message)
    }
}
