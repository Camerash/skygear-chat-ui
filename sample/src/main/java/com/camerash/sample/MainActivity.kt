package com.camerash.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.camerash.skygear.chat.ui.ConversationActivity
import com.camerash.skygear.chat.ui.ConversationTitleOption
import io.skygear.plugins.chat.ChatContainer
import io.skygear.plugins.chat.Conversation
import io.skygear.plugins.chat.GetCallback
import io.skygear.skygear.Container
import io.skygear.skygear.Error
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ConversationsAdapter.ConversationClickListener {

    private lateinit var skygearContainer: Container
    private lateinit var chatContainer: ChatContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!setupSkygear()) {
            finish()
        }

        setupRecyclerView()
        fetchConversations()
    }

    private fun setupSkygear(): Boolean {
        skygearContainer = Container.defaultContainer(this)
        chatContainer = ChatContainer.getInstance(skygearContainer)
        return skygearContainer.auth.currentUser != null
    }

    private fun setupRecyclerView() {
        val llm = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, llm.orientation)
        conversation_recycler_view.layoutManager = llm
        conversation_recycler_view.addItemDecoration(decoration)
    }

    private fun fetchConversations() {
        chatContainer.getConversations(true, object: GetCallback<MutableList<Conversation>> {
            override fun onSuccess(list: MutableList<Conversation>?) {
                if(list == null) return

                conversation_recycler_view.adapter = ConversationsAdapter(this@MainActivity, list)
            }

            override fun onFail(error: Error) {
                Log.d("err", error.detailMessage)
            }
        })
    }

    override fun onConversationClick(conversation: Conversation) {
        val intent = Intent(this, ConversationActivity::class.java)
        intent.putExtra(ConversationActivity.ConversationIntentKey, conversation.toJson().toString())
        intent.putExtra(ConversationActivity.TitleOptionIntentKey,
                if(conversation.title.isNullOrBlank()) ConversationTitleOption.OTHER_PARTICIPANTS else ConversationTitleOption.DEFAULT)
        startActivity(intent)
    }
}
