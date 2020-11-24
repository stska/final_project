package com.example.musicapi.mvp.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface LyricsResultView  extends MvpView {
    void updateCard();
    void setSongTitle(String song);
    void setSingerName(String singerName);
    void setLyrics(String lyrics);
}
