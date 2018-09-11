package com.camerash.sample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import io.skygear.plugins.chat.Conversation

class ConversationsAdapter(val context: Context, val list: MutableList<Conversation>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ConversationClickListener{
        fun onConversationClick(conversation: Conversation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_conversation, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh = holder as ViewHolder
        val conversation = list[position]
        vh.conversationTitle.text = conversation.title
        vh.itemView.setOnClickListener {
            if(context is ConversationClickListener) {
                context.onConversationClick(conversation)
            }
        }

        val participants = conversation.participantIds ?: return

        val colorGenerator = ColorGenerator.MATERIAL

        ChatHelper.getNamesByIds(context, participants) {
            val nameList = it.values
            if(conversation.title.isNullOrBlank()) {
                vh.conversationTitle.text = nameList.joinToString()

                val textDrawable = TextDrawable.builder().buildRound(conversation.title?.get(0).toString(), colorGenerator.getColor(conversation.id))
                vh.conversationIcon.setImageDrawable(textDrawable)
            }

            val lastMsg = conversation.lastMessage ?: return@getNamesByIds
            vh.conversationMessage.text = String.format("%s: %s", it[lastMsg.record.creatorId],
                    if(lastMsg.asset != null) "[Media]" else lastMsg.body)
        }
    }

    override fun getItemCount(): Int = list.size

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val conversationIcon: ImageView = itemView.findViewById(R.id.conversation_icon)
        val conversationTitle: TextView = itemView.findViewById(R.id.conversation_title)
        val conversationMessage: TextView = itemView.findViewById(R.id.conversation_message)
    }


}