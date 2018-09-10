package com.camerash.skygearchatui.holder

import android.view.View
import com.stfalcon.chatkit.messages.MessageHolders
import com.camerash.skygearchatui.model.Message

open class IncomingMessageView<MESSAGE : Message> : MessageHolders.IncomingTextMessageViewHolder<MESSAGE> {

    constructor(itemView: View): super(itemView) {
    }

    override fun onBind(message: MESSAGE) {
    }
}
