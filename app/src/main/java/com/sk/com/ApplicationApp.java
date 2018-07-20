package com.sk.com;

import android.app.Application;
import com.suresh.innapp_purches.InnAppSdk;


public class ApplicationApp extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();

        InnAppSdk.init(this,"Your 64 base Key!"); //64 base key you will get it from play console
    }
}
