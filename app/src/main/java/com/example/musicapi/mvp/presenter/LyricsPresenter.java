package com.example.musicapi.mvp.presenter;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.model.entity.repo.IChartRepo;
import com.example.musicapi.mvp.model.entity.repo.ILyricsRepo;
import com.example.musicapi.mvp.view.LyricsResultView;

import java.io.IOException;
import java.net.FileNameMap;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Scheduler;
import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class LyricsPresenter extends MvpPresenter<LyricsResultView> {
    @Inject
    Router router;
    @Inject
    ILyricsRepo lyricsRepo;
    @Inject
    ILyricsRepo statusResponse;
    @Inject
    Scheduler scheduler;


    private String singer;
    private String song;
    private String apikey = "ac2949d1c1fb1ecb5403e523d703c198"; //временно тут
    private final String UNDEFINED = "Mayday! Something went wrong. There must have been a typo in your request or server is shut down. Please try again.";


    public LyricsPresenter(String singer, String song) {
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
        this.singer = singer;
        this.song = song;
    }

    public void checkStatus() {
        statusResponse.getStatusRespond(song, singer, apikey).subscribe(status -> {
            if (status.getMessageStatus().getHeaderStatusCode().getStatusCode() != 404) {
                loadLyrics();
            } else {
                //  getViewState().setLyrics(UNDEFINED);
                //getViewState().setSingerName("Typo in singer name");
                // getViewState().setSongTitle("Typo in song name");
            }

        });

    }

    public void loadLyrics() {

        lyricsRepo.getLyrics(song, singer, apikey).observeOn(scheduler).subscribe(lyrics -> {

            getViewState().setLyrics(lyrics.getMessage().getBody().getLyrics().getLyricsBody());
            getViewState().setSingerName(singer);
            getViewState().setSongTitle(song);

        });

    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        checkStatus();
    }
}
