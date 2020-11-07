package com.example.musicapi.mvp.model.api;

import com.example.musicapi.mvp.model.entity.MusicApiResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IDataSoutce {
/*    @GET("chart.artists.get")
    Single<MusicApiResponse> loadChart(@Query("page") String page,
                                       @Query("page_size") String numberOfArtists,
                                       @Query("country") String country); */
@GET("chart.artists.get")
Call<MusicApiResponse> loadChart(@Query("page") String page,
                                 @Query("page_size") String numberOfArtists,
                                 @Query("country") String country,
                                @Query("apikey") String apiKey);
}
