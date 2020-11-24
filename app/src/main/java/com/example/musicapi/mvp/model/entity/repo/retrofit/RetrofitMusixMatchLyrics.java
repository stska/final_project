package com.example.musicapi.mvp.model.entity.repo.retrofit;

import com.example.musicapi.mvp.model.api.IDataSource;
import com.example.musicapi.mvp.model.entity.lyricsRespond.LyricsRespond;
import com.example.musicapi.mvp.model.entity.repo.ILyricsRepo;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RetrofitMusixMatchLyrics implements ILyricsRepo {
    final IDataSource api;

    public RetrofitMusixMatchLyrics(IDataSource api) {
        this.api = api;
    }


    @Override
    public Single<LyricsRespond> getLyrics(String song, String singer, String apiKey) {
        return api.getLyrics(song, singer, apiKey).subscribeOn(Schedulers.io());
    }
}
