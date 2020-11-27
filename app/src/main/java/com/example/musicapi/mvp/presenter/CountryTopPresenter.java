package com.example.musicapi.mvp.presenter;

import android.util.Log;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.model.entity.ArtistList;
import com.example.musicapi.mvp.model.entity.repo.IChartRepo;
import com.example.musicapi.mvp.presenter.list.ICountryTopItemView;
import com.example.musicapi.mvp.presenter.list.ICountryTopListPresenter;
import com.example.musicapi.mvp.view.CountryPickView;
import com.example.musicapi.ui.adapter.CountryArtistTopRVAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Scheduler;
import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class CountryTopPresenter extends MvpPresenter<CountryPickView> {

    @Inject
    Router router;
    @Inject
    Scheduler scheduler;
    @Inject
    IChartRepo usersRepo;

    private String apikey = "ac2949d1c1fb1ecb5403e523d703c198"; //временно тут
    private String ct;
    private final String NO_INFO = "There is no provided information for this country";
    private final String EMPTY_SCORE = "0";
    private final String EMPTY_TWITTER = "No information";

    public CountryTopPresenter(String country) {
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
        ct = country;
    }

    private class CountryTopListPresenter implements ICountryTopListPresenter {
        private List<ArtistList> artistListList = new ArrayList<>();
        @Override
        public void onItemClick(ICountryTopItemView view) {

        }

        @Override
        public void bindView(ICountryTopItemView view) {
            if(artistListList.size() != 0) {
                ArtistList artistList = artistListList.get(view.getPos());
                view.setArtName(artistList.getArtist().getArtistName());
                view.setArtScore(artistList.getArtist().getArtistRating().toString());
                view.setArtTwitter(artistList.getArtist().getArtistTwitterUrl().isEmpty() ? EMPTY_TWITTER : artistList.getArtist().getArtistTwitterUrl());
            }else {
                view.setArtName( NO_INFO);
                view.setArtScore(EMPTY_SCORE);
                view.setArtTwitter(EMPTY_TWITTER);
            }
        }

        @Override
        public int getCount() {
            if(artistListList.size() != 0){
                return artistListList.size();
            }else return 1;
        }
    }

    private CountryTopPresenter.CountryTopListPresenter countryTopListPresente = new CountryTopPresenter.CountryTopListPresenter();

    public ICountryTopListPresenter getPresenter() {
        return countryTopListPresente;
    }

    private void loadChart() {
        usersRepo.getChart("1", "3", ct, apikey).observeOn(scheduler).subscribe(chart -> {
           // chart.getMessage().getBody().getArtistList();
           // Log.d(getClass().getSimpleName(), chart.getMessage().getBody().getArtistList().get(1).getArtist().getArtistName());
            if(chart.getMessage().getBody().getArtistList().size() == 0){
                countryTopListPresente.artistListList.clear();
                getViewState().updateList();
            }else {
                countryTopListPresente.artistListList.clear();
                countryTopListPresente.artistListList.addAll(chart.getMessage().getBody().getArtistList());
                getViewState().updateList();
            }
        });

    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().init();
        loadChart();
    }
}

