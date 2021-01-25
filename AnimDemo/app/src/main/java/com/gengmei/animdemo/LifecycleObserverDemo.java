package com.gengmei.animdemo;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by liukunyu on 2020/12/25 14:53.
 * desc:
 */
public class LifecycleObserverDemo implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner, Lifecycle.Event event) {
        Log.e("Luckily", "onAny: " + event.name());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.e("Luckily", "onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {

        Log.e("Luckily", "onDestroy: ");
    }
}
