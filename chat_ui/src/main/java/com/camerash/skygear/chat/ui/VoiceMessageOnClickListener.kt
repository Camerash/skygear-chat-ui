package com.camerash.skygear.chat.ui

import com.camerash.skygear.chat.ui.model.VoiceMessage

interface VoiceMessageOnClickListener {
    fun onVoiceMessageClick(voiceMessage: VoiceMessage)
}