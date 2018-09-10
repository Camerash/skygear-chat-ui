package com.camerash.skygear.chat.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.camerash.skygear.chat.ui.model.Message
import com.camerash.skygear.chat.ui.utils.AvatarBuilder
import com.stfalcon.chatkit.utils.ShapeImageView

class DefaultAvatarView(context: Context, attributeSet: AttributeSet) : ShapeImageView(context, attributeSet) {

    var imageLoader: DefaultAvatarImageLoader? = null

    init {
    }

    fun onBind(message: Message) {
        imageLoader = DefaultAvatarImageLoader(context, AvatarBuilder())
        imageLoader?.loadImage(this, message.user?.avatar)
        layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
    }
}