package com.star.uibestpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter(private val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            Msg.MsgType.TYPE_RECEIVED.value -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.msg_left_item, parent, false)
                LeftViewHolder(view)
            }
            Msg.MsgType.TYPE_SENT.value -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.msg_right_item, parent, false)
                RightViewHolder(view)
            }
            else -> throw IllegalArgumentException()
        }

    override fun getItemCount() = msgList.size

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type.value
    }
}