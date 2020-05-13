package com.star.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val msgList = mutableListOf<Msg>()
    private lateinit var adapter: MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMsgs()

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }

        recyclerView.adapter = adapter

        send.setOnClickListener {
            val content = inputText.text.toString()
            if (content.isNotBlank()) {
                val msg = Msg(content, Msg.MsgType.TYPE_SENT)
                msgList.add(msg)
                adapter.notifyItemInserted(msgList.size - 1)
                recyclerView.scrollToPosition(msgList.size - 1)
                inputText.setText("")
            }
        }
    }

    private fun initMsgs() {

        val msg1 = Msg("Hello guy.", Msg.MsgType.TYPE_RECEIVED)
        val msg2 = Msg("Hello. Who is that?", Msg.MsgType.TYPE_SENT)
        val msg3 = Msg("This is Tom. Nice talking to you.", Msg.MsgType.TYPE_RECEIVED)

        msgList.addAll(listOf(msg1, msg2, msg3))
    }
}
