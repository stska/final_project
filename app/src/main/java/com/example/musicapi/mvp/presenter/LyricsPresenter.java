package com.example.musicapi.mvp.presenter;

import android.util.Log;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.model.entity.lyricsRespond.LyricsRespond;
import com.example.musicapi.mvp.model.entity.repo.IChartRepo;
import com.example.musicapi.mvp.model.entity.repo.ILyricsRepo;
import com.example.musicapi.mvp.view.LyricsResultView;

import java.io.IOException;
import java.net.FileNameMap;

import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class LyricsPresenter extends MvpPresenter<LyricsResultView> {
    @Inject
    ILyricsRepo lyricsRepo;
    @Inject
    Scheduler scheduler;


    private String singer;
    private String song;
    private String apikey = "ac2949d1c1fb1ecb5403e523d703c198"; //временно тут, пока не найду нормальное место,нужно почитать, гду лучше всего хранить
    private final String UNDEFINED = "Mayday! Something went wrong. There must have been a typo in your request or server is shut down. Please try again.";
    private final String SUBSCRIBE_POINT = getClass().getSimpleName();
    private final String SUBSCRIBE_MSG = "Successfully subscribed!";


    public LyricsPresenter(String singer, String song) {
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
        this.singer =  singer.substring(0,1).toUpperCase() + singer.substring(1).toLowerCase();;
        this.song =  song.substring(0,1).toUpperCase() + song.substring(1).toLowerCase();;
    }

    public void loadLyrics() {

        lyricsRepo.getLyrics(song, singer, apikey).observeOn(scheduler).subscribe(new SingleObserver<LyricsRespond>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(SUBSCRIBE_POINT, SUBSCRIBE_MSG);
            }

            @Override
            public void onSuccess(@NonNull LyricsRespond lyricsRespond) {
              int status = lyricsRespond.getMessage().getHeader().getStatusCode();
              if(status == 200){
                  getViewState().setLyrics(lyricsRespond.getMessage().getBody().getLyrics().getLyricsBody());
                  getViewState().setSingerName(singer);
                  getViewState().setSongTitle(song);
              }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                  e.printStackTrace();
                getViewState().setLyrics(UNDEFINED);
                getViewState().setSingerName(singer);
                getViewState().setSongTitle(song);
            }
        });

    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadLyrics();
    }
}
