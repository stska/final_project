package com.example.musicapi;

import android.app.Application;
import android.content.Context;

import com.example.musicapi.di.AppComponent;
import com.example.musicapi.di.DaggerAppComponent;
import com.example.musicapi.di.module.AppModule;

public class MusicInfoApplication extends Application {
    public static MusicInfoApplication INSTANCE;
    public static final boolean DEBUG = true;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
    public static Context getAppContext() {
        return INSTANCE;
    }

  public AppComponent getAppComponent() {
      return appComponent;
  }
}
