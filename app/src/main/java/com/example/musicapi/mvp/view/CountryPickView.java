package com.example.musicapi.mvp.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface CountryPickView extends MvpView {
    void init();
    void setArtName(String name);
    void setArtScore(String score);
    void setArtSongName(String songName);
    void updateList();

}
