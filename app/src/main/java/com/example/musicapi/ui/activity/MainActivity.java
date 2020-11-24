package com.example.musicapi.ui.activity;

import android.os.Bundle;
import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.R;
import com.example.musicapi.mvp.model.presenter.MainPresenter;
import com.example.musicapi.mvp.view.MainView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import javax.inject.Inject;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    private BottomNavigationView btv;


    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    private final long PAGE_ONE = 2131296503;

    @Inject
    NavigatorHolder navigatorHolder;
    Navigator navigator = new SupportAppNavigator(this, getSupportFragmentManager(), R.id.container);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MusicInfoApplication.INSTANCE.getAppComponent().inject(this);
        btv = findViewById(R.id.bottom_navigation);
        btv.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == PAGE_ONE) {
                presenter.searchOptions(2);
            } else {
                presenter.searchOptions(1);
            }
            return true;
        });

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

