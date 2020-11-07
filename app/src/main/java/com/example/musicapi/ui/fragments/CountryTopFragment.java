package com.example.musicapi.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.musicapi.R;
import com.example.musicapi.mvp.model.api.IDataSoutce;
import com.example.musicapi.mvp.model.entity.MusicApiResponse;
import com.example.musicapi.mvp.model.presenter.CountryPickPresenter;
import com.example.musicapi.mvp.model.presenter.CountryTopPresenter;
import com.example.musicapi.mvp.view.CountryPickView;

import javax.security.auth.callback.Callback;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import retrofit2.Call;
import retrofit2.Response;

public class CountryTopFragment extends MvpAppCompatFragment implements CountryPickView{
    @InjectPresenter
    CountryTopPresenter presenter;
   private IDataSoutce source;
    private static final String COUNTRY = "country";
    private String apikey = "ac2949d1c1fb1ecb5403e523d703c198"; //временно тут

    //TODO дописать здесь @ProvidedPresenter
    
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
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void init() {

    }

    @Override
    public void updateList() {

    }
    private void loadListr(){
       //TODO здесь будет запрос на зугрусти чарта переданной страны


    }
}
