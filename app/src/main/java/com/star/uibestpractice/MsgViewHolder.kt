package com.star.uibestpractice

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

sealed class MsgViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class LeftViewHolder(itemView: View) : MsgViewHolder(itemView) {
    val leftMsg: TextView = itemView.findViewById(R.id.leftMsg)
}

class RightViewHolder(itemView: View) : MsgViewHolder(itemView) {
    val rightMsg: TextView = itemView.findViewById(R.id.rightMsg)
}