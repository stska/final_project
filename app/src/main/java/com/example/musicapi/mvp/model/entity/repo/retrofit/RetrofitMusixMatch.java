package com.example.musicapi.mvp.model.entity.repo.retrofit;

import com.example.musicapi.mvp.model.api.IDataSource;
import com.example.musicapi.mvp.model.entity.MusicApiResponse;
import com.example.musicapi.mvp.model.entity.repo.IChartRepo;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RetrofitMusixMatch implements IChartRepo{
   // final IChartRepo repo;
    final IDataSource api;
    public RetrofitMusixMatch(IDataSource api){
        this.api = api;
    }
    @Override
    public Single<MusicApiResponse> getChart(String page,String numberOfArtists,String country,String apiKey) {
        return api.loadChart(page,numberOfArtists,country,apiKey).subscribeOn(Schedulers.io());
    }
}
