package com.example.musicapi.mvp.model.entity.room;

import android.os.RecoverySystem;

import com.example.musicapi.mvp.model.api.IDataSource;
import com.example.musicapi.mvp.model.entity.Artist;
import com.example.musicapi.mvp.model.entity.ArtistList;
import com.example.musicapi.mvp.model.entity.MusicApiResponse;
import com.example.musicapi.mvp.model.entity.repo.IChartRepo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;

public class RoomMusicChart implements IRoomChartRepo {
    private String apikey = "ac2949d1c1fb1ecb5403e523d703c198"; //временно тут


    @Override
    public Single<MusicApiResponse> getChart(IDataSource api, String country) {
        return api.loadChart("1","3",country,apikey);
    }
}
