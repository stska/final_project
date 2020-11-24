package com.example.musicapi.di;


import com.example.musicapi.di.module.ApiModule;
import com.example.musicapi.di.module.AppModule;
import com.example.musicapi.di.module.CiceroneModule;
import com.example.musicapi.di.module.RepoModule;
import com.example.musicapi.mvp.model.presenter.CountryPickPresenter;
import com.example.musicapi.mvp.model.presenter.CountryTopPresenter;
import com.example.musicapi.mvp.model.presenter.LyricsPresenter;
import com.example.musicapi.mvp.model.presenter.LyricsSearchPresenter;
import com.example.musicapi.mvp.model.presenter.MainPresenter;
import com.example.musicapi.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApiModule.class,
                AppModule.class,
                CiceroneModule.class,
                RepoModule.class
        }
)
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
    void inject(CountryPickPresenter countryPickPresenter);
    void inject(CountryTopPresenter countryTopPresenter);
    void inject(LyricsPresenter lyricsPresenter);
    void inject(LyricsSearchPresenter lyricsSearchPresenter);
}
