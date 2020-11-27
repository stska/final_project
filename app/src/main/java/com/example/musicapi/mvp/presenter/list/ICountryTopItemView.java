package com.example.musicapi.mvp.presenter.list;

import retrofit2.http.Url;

public interface ICountryTopItemView extends IItemView {
    void setArtName(String name);
    void setArtScore(String score);
    void setArtTwitter(String twitURL);

}
