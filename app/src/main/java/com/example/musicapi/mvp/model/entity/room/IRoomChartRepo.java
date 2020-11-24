package com.example.musicapi.mvp.model.entity.room;

import com.example.musicapi.mvp.model.api.IDataSource;
import com.example.musicapi.mvp.model.entity.MusicApiResponse;

import io.reactivex.rxjava3.core.Single;

public interface IRoomChartRepo {
    Single<MusicApiResponse> getChart(IDataSource api, String country);
}
