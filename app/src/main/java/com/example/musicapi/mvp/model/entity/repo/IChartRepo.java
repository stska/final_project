package com.example.musicapi.mvp.model.entity.repo;

import com.example.musicapi.mvp.model.api.IDataSource;
import com.example.musicapi.mvp.model.entity.MusicApiResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface IChartRepo {
    Single <MusicApiResponse> getChart(String page,String numberOfArtists,String country,String apiKey);
}
