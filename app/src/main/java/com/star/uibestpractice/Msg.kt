package com.star.uibestpractice

class Msg(val content: String, val type: MsgType) {

    enum class MsgType(val value: Int) {
        TYPE_RECEIVED(0),
        TYPE_SENT(1),
    }
}