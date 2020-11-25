package com.example.musicapi.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.musicapi.R;
import com.example.musicapi.mvp.presenter.LyricsSearchPresenter;
import com.example.musicapi.mvp.view.LyricsSearchView;
import com.google.android.material.textfield.TextInputLayout;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class LyricsSearchFragment extends MvpAppCompatFragment implements LyricsSearchView {
    @InjectPresenter
    LyricsSearchPresenter presenter;

    private View view;
    private Button btn;

    private TextInputLayout textInputLayout;
    private TextInputLayout singerInputLayout;
    private final String EMPTY_FIELD = "Fill in all fields";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.get_lyrics_layout, container, false);
        textInputLayout = view.findViewById(R.id.songTextField);
        singerInputLayout = view.findViewById(R.id.singerTextField);

        btn = view.findViewById(R.id.searchTopCtBtn);
        btn.setOnClickListener(s -> {
            String singer = singerInputLayout.getEditText().getText().toString();
            String song = textInputLayout.getEditText().getText().toString();
            Log.d(getClass().getSimpleName(), "song: " + song);
            if(!singer.isEmpty() && !song.isEmpty()) {
                presenter.goToLyricsScreen(singer, song);
            }else Toast.makeText(getContext(), EMPTY_FIELD,Toast.LENGTH_LONG).show();
        });
        return view;
    }

}
