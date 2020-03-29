package com.mygate.ola

import android.app.Application
import org.greenrobot.eventbus.EventBus

class AppContoller: Application() {

    override fun onCreate() {
        super.onCreate()
        EventBus.builder()
            .sendNoSubscriberEvent(false)
            .throwSubscriberException(true)
            .logNoSubscriberMessages(false).build()
    }

}