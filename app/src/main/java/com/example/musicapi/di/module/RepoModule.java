package com.example.musicapi.di.module;

import com.example.musicapi.mvp.model.api.IDataSource;
import com.example.musicapi.mvp.model.entity.repo.IChartRepo;
import com.example.musicapi.mvp.model.entity.repo.ILyricsRepo;
import com.example.musicapi.mvp.model.entity.repo.retrofit.RetrofitMusixMatch;
import com.example.musicapi.mvp.model.entity.repo.retrofit.RetrofitMusixMatchLyrics;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepoModule {

    @Provides
    public  IChartRepo chart(IDataSource api){
        return new RetrofitMusixMatch(api);

    }

    @Provides
    public ILyricsRepo lyrics(IDataSource api) {
        return  new RetrofitMusixMatchLyrics(api);
    }

}
