package com.example.musicapi.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.musicapi.R;
import com.example.musicapi.mvp.model.presenter.LyricsPresenter;
import com.example.musicapi.mvp.view.LyricsResultView;
import com.example.musicapi.mvp.view.LyricsViewCard;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class LyricsFragment  extends MvpAppCompatFragment implements LyricsResultView {
    private static final String SINGER = "singer";
    private static final String SONG = "song";
    private String singer;
    private String song;
    private View view;
    private TextView songTitle;
    private TextView singerTitle;
    private TextView lyricsTextview;
    private CardView cardView;

    @InjectPresenter
    LyricsPresenter presenter;

     @ProvidePresenter
    LyricsPresenter provideLyricsPresenter(){
        final String singer = getArguments().getString(SINGER);
        final String song = getArguments().getString(SONG);
        return new LyricsPresenter(singer,song);

    }

  public static LyricsFragment getInstance(String singer,String song){
         LyricsFragment fragment = new LyricsFragment();
         Bundle args = new Bundle();
         args.putString(SINGER,singer);
         args.putString(SONG,song);
         fragment.setArguments(args);
         return fragment;
  }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.lyrics_representation_layout,container,false);
        songTitle = view.findViewById(R.id.songLyricsTitle);
        singerTitle = view.findViewById(R.id.singerLyricsId);
        lyricsTextview = view.findViewById(R.id.lyrics);
        cardView = view.findViewById(R.id.card);
        return  view;
    }

    @Override
    public void updateCard() {
         //TODO убрать, то что хотелось пока не получилось
    }


    @Override
    public void setSongTitle(String song) {
        songTitle.setText(song);
    }

    @Override
    public void setSingerName(String singerName) {
            singerTitle.setText(singerName);
    }

    @Override
    public void setLyrics(String lyrics) {
        lyricsTextview.setText(lyrics);
    }
}
