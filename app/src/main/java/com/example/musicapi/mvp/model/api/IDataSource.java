package com.example.musicapi.mvp.model.api;

import com.example.musicapi.mvp.model.entity.MusicApiResponse;
import com.example.musicapi.mvp.model.entity.lyricsRespond.Header;
import com.example.musicapi.mvp.model.entity.lyricsRespond.LyricsRespond;
import com.example.musicapi.mvp.model.entity.lyricsRespond.checkHeaderResponse.Response;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IDataSource {
   @GET("chart.artists.get")
    Single<MusicApiResponse> loadChart(@Query("page") String page,
                                       @Query("page_size") String numberOfArtists,
                                       @Query("country") String country,
                                       @Query("apikey") String apiKey);
    @GET("matcher.lyrics.get?format=json&callback=callback")
    Single<LyricsRespond> getLyrics(@Query("q_track") String singer,
                                    @Query("q_artist") String song,
                                    @Query("apikey") String apiKey);

    @GET("matcher.lyrics.get?format=json&callback=callback")
    Single<Response> checkStatusResponse(@Query("q_track") String singer,
                                         @Query("q_artist") String song,
                                         @Query("apikey") String apiKey);

}
