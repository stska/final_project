package com.example.musicapi.mvp.presenter;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.view.MainView;
import com.example.musicapi.navigation.Screens;

import javax.inject.Inject;

import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class MainPresenter extends MvpPresenter<MainView> {
    @Inject
    Router router;

    public MainPresenter() {
        super();
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        router.replaceScreen(new Screens.CountryTopScreen());
    }
    public void searchOptions(int pageId) {
        if (pageId == 1) {
            router.navigateTo(new Screens.LyricsSearchScreen());
        } else {
            router.replaceScreen(new Screens.CountryTopScreen());
        }
    }

    public void backClicked() {
        router.exit();
    }
}
