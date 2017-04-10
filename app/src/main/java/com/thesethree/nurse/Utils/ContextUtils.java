package com.thesethree.nurse.Utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Eric on 2017-4-10.
 */

public class ContextUtils extends Application {
    private static ContextUtils instance;

    public static ContextUtils getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
        Fresco.initialize(this);
    }
}
