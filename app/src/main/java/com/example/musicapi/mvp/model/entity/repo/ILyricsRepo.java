package com.example.musicapi.mvp.model.entity.repo;

import com.example.musicapi.mvp.model.entity.MusicApiResponse;
import com.example.musicapi.mvp.model.entity.lyricsRespond.LyricsRespond;

import io.reactivex.rxjava3.core.Single;

public interface ILyricsRepo {
    Single<LyricsRespond> getLyrics(String song,String singer, String apiKey);
}
