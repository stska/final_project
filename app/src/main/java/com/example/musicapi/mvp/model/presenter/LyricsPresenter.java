package com.example.musicapi.mvp.model.presenter;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.mvp.model.entity.repo.ILyricsRepo;
import com.example.musicapi.mvp.view.LyricsResultView;

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
    Scheduler scheduler;


    private String singer;
    private String song;
    private String apikey = "ac2949d1c1fb1ecb5403e523d703c198"; //временно тут


    public LyricsPresenter(String singer, String song) {
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
        this.singer = singer;
        this.song = song;
    }

    public void loadLyrics() {
        lyricsRepo.getLyrics(song, singer, apikey).observeOn(scheduler).subscribe(lyrics -> {
            if(lyrics.getMessage().getHeader().getStatusCode() == 200) {
                getViewState().setLyrics(lyrics.getMessage().getBody().getLyrics().getLyricsBody());
                getViewState().setSingerName(singer);
                getViewState().setSongTitle(song);
            }else {
                getViewState().setLyrics("");
                getViewState().setSingerName("Typo in singer name");
                getViewState().setSongTitle("Typo in song name");
            }
        });


    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadLyrics();
    }
}
