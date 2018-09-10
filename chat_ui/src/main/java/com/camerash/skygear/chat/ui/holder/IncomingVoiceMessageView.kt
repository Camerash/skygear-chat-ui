package com.camerash.skygear.chat.ui.holder

import android.view.View
import com.camerash.skygear.chat.ui.model.VoiceMessage
import com.stfalcon.chatkit.messages.MessageHolders

class IncomingVoiceMessageView(view: View) :
        MessageHolders.IncomingTextMessageViewHolder<VoiceMessage>(view) {
    var voiceMessageView: VoiceMessageView? = null
    var usernameMessageView: UsernameMessageView? = null
    var senderAvatarMessageView: SenderAvatarMessageView? = null
    var timeMessageView: IncomingTimeMessageView? = null
    var bubbleView: IncomingBubbleMessageView? = null

    init {
        voiceMessageView = VoiceMessageView(itemView, true)
        usernameMessageView = UsernameMessageView(itemView)
        senderAvatarMessageView = SenderAvatarMessageView(itemView)
        bubbleView = IncomingBubbleMessageView(itemView)
        timeMessageView = IncomingTimeMessageView(itemView)
    }

    override fun onBind(message: VoiceMessage) {
        super.onBind(message)
        voiceMessageView?.onBind(message)
        usernameMessageView?.onBind(message)
        senderAvatarMessageView?.onBind(message)
        timeMessageView?.onBind(message)
        bubbleView?.onBind(message)
    }
}
