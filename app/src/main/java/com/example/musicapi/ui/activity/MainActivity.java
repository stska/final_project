package com.example.musicapi.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.R;
import com.example.musicapi.mvp.model.api.IDataSoutce;
import com.example.musicapi.mvp.model.entity.MusicApiResponse;
import com.example.musicapi.mvp.model.presenter.MainPresenter;
import com.example.musicapi.mvp.view.MainView;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainView {
 private IDataSoutce dataSoutce;


 @InjectPresenter
    MainPresenter presenter;
 @ProvidePresenter
    MainPresenter provideMainPresenter(){ return new MainPresenter();}

   @Inject
    NavigatorHolder navigatorHolder;
    Navigator navigator = new SupportAppNavigator(this, getSupportFragmentManager(), R.id.container);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);

    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

