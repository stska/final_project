package com.example.musicapi.navigation;

import androidx.fragment.app.Fragment;

import com.example.musicapi.ui.fragments.CountryPickFragment;
import com.example.musicapi.ui.fragments.CountryTopFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {
    public static class CountryTopScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new CountryPickFragment();
        }
    }
    public static class CountrySongs extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new CountryTopFragment();
        }
    }

}
