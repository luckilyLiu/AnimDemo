package com.gengmei.animdemo.pageclickmonitor

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class ClickAccessibilityService: AccessibilityService() {

    override fun onInterrupt() {
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val eventType = event?.eventType
        val className = event?.className.toString()


        when (eventType) {
            AccessibilityEvent.TYPE_VIEW_CLICKED -> Log.e(TAG,"【无障碍方案】点击了一个按钮=$className")
        }
    }

    companion object {
        private const val TAG = "AccessibilityService"
    }


}