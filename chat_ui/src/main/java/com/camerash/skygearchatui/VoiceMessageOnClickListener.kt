package com.camerash.skygearchatui

import com.camerash.skygearchatui.model.VoiceMessage

interface VoiceMessageOnClickListener {
    fun onVoiceMessageClick(voiceMessage: VoiceMessage)
}