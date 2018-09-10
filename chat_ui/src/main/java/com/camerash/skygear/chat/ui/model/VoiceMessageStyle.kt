package com.camerash.skygear.chat.ui.model

class VoiceMessageStyle {
    val buttonColorForIncomingMessages: Int
    val buttonColorForOutgoingMessages: Int
    constructor(buttonColorForIncomingMessages: Int, buttonColorForOutgoingMessages: Int) {
        this.buttonColorForIncomingMessages = buttonColorForIncomingMessages
        this.buttonColorForOutgoingMessages = buttonColorForOutgoingMessages
    }
}