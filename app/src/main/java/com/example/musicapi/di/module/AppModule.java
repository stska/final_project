package com.example.musicapi.di.module;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.model.entity.MusicApiResponse;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;

@Module
public class AppModule {
    private MusicInfoApplication app;

    public AppModule(MusicInfoApplication app){
        this.app =app;
    }
    @Provides
    public MusicInfoApplication app() {return app; }

    @Provides
    public Scheduler mainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
