package com.camerash.skygearchatui.holder

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.stfalcon.chatkit.R
import com.camerash.skygearchatui.model.Message
import com.camerash.skygearchatui.model.MessageBubbleStyle
import io.skygear.plugins.chat.ui.R as UiKitResource

open class BaseBubbleMessageView(itemView: View, drawable: Int, val isIncoming: Boolean) {
    val bubble: ViewGroup?
    val background: Drawable
    val messageText: TextView?
    val durationText: TextView?

    init {
        this.bubble = itemView.findViewById<ViewGroup>(R.id.bubble)
        this.messageText = itemView.findViewById<TextView>(R.id.messageText)
        this.durationText = itemView.findViewById<TextView>(UiKitResource.id.duration)
        this.background = ContextCompat.getDrawable(itemView.context, drawable)!!.constantState.newDrawable()
    }

    fun onBind(message: Message) {
        val color = backgroundColor(message.style.bubbleStyle)

        /*
          Workaround found on stackoverflow
          https://stackoverflow.com/questions/36731919/drawablecompat-settint-not-working-on-api-19
        */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            DrawableCompat.setTint(background, color)
        } else {
            background.mutate().setColorFilter(color, PorterDuff.Mode.SRC_IN)
        }
        bubble?.background = background

        val textColor = if (isIncoming) message.style.bubbleStyle.textColorForIncomingMessages
                        else message.style.bubbleStyle.textColorForOutgoingMessages
        messageText?.setTextColor(textColor)
        durationText?.setTextColor(textColor)
    }

    open fun backgroundColor(style: MessageBubbleStyle): Int {
        return -1
    }
}