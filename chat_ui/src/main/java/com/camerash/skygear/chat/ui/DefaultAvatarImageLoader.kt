package com.camerash.skygear.chat.ui

import android.content.Context
import android.widget.ImageView
import com.camerash.skygear.chat.ui.utils.AvatarBuilder
import com.camerash.skygear.chatkit.commons.ImageLoader
import com.squareup.picasso.Picasso

class DefaultAvatarImageLoader(
    val context: Context,
    val avatarBuilder: AvatarBuilder
) : ImageLoader {

    override fun loadImage(imageView: ImageView?, url: String?, payload: Any?) {
        if (url == null) {
            return
        }

        if (this.avatarBuilder.isValidAvatarBuilderUri(url)) {
            val bm = this.avatarBuilder.avatarForUri(url)
            imageView?.setImageBitmap(bm)
            return
        }

        var creator = Picasso.get()
                .load(url)
        creator.fit().centerCrop()
        creator.into(imageView)
    }
}
