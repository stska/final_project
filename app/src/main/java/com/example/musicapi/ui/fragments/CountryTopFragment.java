package com.example.musicapi.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapi.R;
import com.example.musicapi.mvp.model.api.IDataSource;
import com.example.musicapi.mvp.model.presenter.CountryTopPresenter;
import com.example.musicapi.mvp.view.CountryPickView;
import com.example.musicapi.ui.adapter.CountryArtistTopRVAdapter;

import org.w3c.dom.Text;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class CountryTopFragment extends MvpAppCompatFragment implements CountryPickView{
    @InjectPresenter
    CountryTopPresenter presenter;
    private static final String COUNTRY = "country";
    private View view;
    private TextView artistName;
    private TextView artistScore;
    private TextView artistSong;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private CountryArtistTopRVAdapter adapter;



    @ProvidePresenter
    CountryTopPresenter provideCountryTopPresenter() {
        final String country = getArguments().getString(COUNTRY);
        return new CountryTopPresenter(country);
    }

    public static CountryTopFragment getInstance(String country){
        CountryTopFragment fragment = new CountryTopFragment();
        Bundle arguments = new Bundle();
        arguments.putString(COUNTRY,country);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.country_top_screen,container,false);
       recyclerView = (RecyclerView) view.findViewById(R.id.rvCountriesArtistTop);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
      //artistName = view.findViewById(R.id.artistName);
      // artistSong = view.findViewById(R.id.artistSong);
       //artistScore = view.findViewById(R.id.artistScore);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void init() {
        layoutManager = new LinearLayoutManager(view.getContext());
        adapter = new CountryArtistTopRVAdapter(presenter.getPresenter());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setArtName(String name) {
        artistName.setText(name);
    }

    @Override
    public void setArtScore(String score) {
        artistScore.setText(score);
    }

    @Override
    public void setArtSongName(String songName) {
            artistSong.setText(songName);
    }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }


    private void loadListr(){
       //TODO здесь будет запрос на зугрусти чарта переданной страны
           //  source.loadChart("1","3","it",apikey).

    }

}
/*
public class CountryTopFragment extends MvpAppCompatFragment implements CountryPickView{
    @InjectPresenter
    CountryTopPresenter presenter;
    private static final String COUNTRY = "country";
    private View view;
    private TextView artistName;
    private TextView artistScore;
    private TextView artistSong;

    //TODO дописать здесь @ProvidedPresenter
    @ProvidePresenter
    CountryTopPresenter provideCountryTopPresenter() {
        final String country = getArguments().getString(COUNTRY);
        return new CountryTopPresenter(country);
    }

    public static CountryTopFragment getInstance(String country){
        CountryTopFragment fragment = new CountryTopFragment();
        Bundle arguments = new Bundle();
        arguments.putString(COUNTRY,country);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.country_top_screen,container,false);
       artistName = view.findViewById(R.id.artistName);
       artistSong = view.findViewById(R.id.artistSong);
       artistScore = view.findViewById(R.id.artistScore);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void init() {

    }

    @Override
    public void setArtName(String name) {
        artistName.setText(name);
    }

    @Override
    public void setArtScore(String score) {
        artistScore.setText(score);
    }

    @Override
    public void setArtSongName(String songName) {
            artistSong.setText(songName);
    }


    private void loadListr(){
       //TODO здесь будет запрос на зугрусти чарта переданной страны
           //  source.loadChart("1","3","it",apikey).

    }

}
 */