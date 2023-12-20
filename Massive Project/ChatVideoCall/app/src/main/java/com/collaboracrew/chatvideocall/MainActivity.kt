package com.collaboracrew.chatvideocall

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.zegocloud.uikit.prebuilt.call.config.ZegoCallDurationConfig
import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var userIdTextField: EditText
    private var startTimeMillis: Long = 0
    private val durationLimitSeconds = 1 * 60
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userIdTextField = findViewById(R.id.user_id_text_field)
        val btInput = findViewById<CardView>(R.id.button_next)

        btInput.setOnClickListener {
            val userId = userIdTextField.text.toString()
            val intent = Intent(this@MainActivity, VideoCallActivity::class.java)
            intent.putExtra("userID", userId)
            Log.e("user id", "user id: $userId")
            startActivity(intent)

            videoCallServices(userId)
        }
    }

    private fun videoCallServices(userID: String) {
        val appID: Long = 1954081226
        val appSign = "f3c0a8350883711406b34860c0931eb3c307c82d80229cb5d7ee234fcf56f730"
        val application = application
        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()
        val callDuration = ZegoCallDurationConfig()
        callDuration.isVisible = true
        startTimeMillis = SystemClock.elapsedRealtime()

        Handler().postDelayed({
            val elapsedTimeSeconds = TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - startTimeMillis)
            if (elapsedTimeSeconds >= durationLimitSeconds) {
                ZegoUIKitPrebuiltCallInvitationService.endCall()
            }
        }, durationLimitSeconds * 1000L)

        val notificationConfig = ZegoNotificationConfig()
        notificationConfig.sound = "zego_uikit_sound_call"
        notificationConfig.channelID = "CallInvitation"
        notificationConfig.channelName = "CallInvitation"
        ZegoUIKitPrebuiltCallInvitationService.init(
            application,
            appID,
            appSign,
            userID,
            userID,
            callInvitationConfig
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        ZegoUIKitPrebuiltCallInvitationService.unInit()
    }
}
