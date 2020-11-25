package com.example.musicapi.mvp.presenter;


import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.view.CountryPickView;
import com.example.musicapi.navigation.Screens;
import javax.inject.Inject;
import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class CountryPickPresenter extends MvpPresenter<CountryPickView> {
    @Inject
    Router router;

    public CountryPickPresenter(){
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
    }
    public void pickCountryFromArray(String country){
        router.navigateTo(new Screens.CountrySongs(country));
    }

}
