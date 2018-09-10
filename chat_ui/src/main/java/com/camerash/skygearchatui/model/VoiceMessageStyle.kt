package com.camerash.skygearchatui.model

class VoiceMessageStyle {
    val buttonColorForIncomingMessages: Int
    val buttonColorForOutgoingMessages: Int
    constructor(buttonColorForIncomingMessages: Int, buttonColorForOutgoingMessages: Int) {
        this.buttonColorForIncomingMessages = buttonColorForIncomingMessages
        this.buttonColorForOutgoingMessages = buttonColorForOutgoingMessages
    }
}