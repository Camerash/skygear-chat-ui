package com.camerash.skygear.chat.ui.holder

import android.view.View
import com.camerash.skygear.chat.ui.model.Message
import com.stfalcon.chatkit.messages.MessageHolders

open class IncomingMessageView<MESSAGE : Message> : MessageHolders.IncomingTextMessageViewHolder<MESSAGE> {

    constructor(itemView: View): super(itemView) {
    }

    override fun onBind(message: MESSAGE) {
    }
}
