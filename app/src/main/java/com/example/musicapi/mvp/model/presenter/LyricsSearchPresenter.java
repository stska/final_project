package com.example.musicapi.mvp.model.presenter;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.model.entity.repo.IChartRepo;
import com.example.musicapi.mvp.model.entity.repo.ILyricsRepo;
import com.example.musicapi.mvp.view.LyricsSearchView;
import com.example.musicapi.navigation.Screens;

import javax.inject.Inject;

import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class LyricsSearchPresenter extends MvpPresenter<LyricsSearchView> {
    @Inject
    Router router;


    public LyricsSearchPresenter() {
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
    }

    public void goToLyricsScreen(String artist, String song) {
        router.navigateTo(new Screens.LyricsScreenRepresentation(artist, song));
    }

}
