package com.example.musicapi.mvp.model.presenter;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.view.CountryPickView;

import javax.inject.Inject;

import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class CountryTopPresenter extends MvpPresenter<CountryPickView> {
    @Inject
    Router router;

    public CountryTopPresenter(String country){
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
    }
}
