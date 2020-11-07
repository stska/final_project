package com.example.musicapi.mvp.model.presenter;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.view.CountryPickView;
import com.example.musicapi.mvp.view.IItemView;
import com.example.musicapi.navigation.Screens;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Scheduler;
import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class CountryPickPresenter extends MvpPresenter<CountryPickView> {
    @Inject
    Router router;
    @Inject
    Scheduler scheduler;

    public CountryPickPresenter(){
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
    }
    public void pickCountryFromArray(String country){
        System.out.println(country);
        router.navigateTo(new Screens.CountrySongs());
    }

}
