package com.example.musicapi.navigation;

import androidx.fragment.app.Fragment;

import com.example.musicapi.ui.fragments.CountryPickFragment;
import com.example.musicapi.ui.fragments.CountryTopFragment;
import com.example.musicapi.ui.fragments.LyricsFragment;
import com.example.musicapi.ui.fragments.LyricsSearchFragment;

import org.jetbrains.annotations.Nullable;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {
    public static class CountryTopScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new CountryPickFragment();
        }
    }
    public static class CountrySongs extends SupportAppScreen {
        private  final  String ct;
        public CountrySongs(String ct) { this.ct = ct; }
        @Override
        public Fragment getFragment() {
            return CountryTopFragment.getInstance(ct);
        }
    }
    public static class LyricsSearchScreen extends SupportAppScreen{
        @Nullable
        @Override
        public Fragment getFragment() {
            return new LyricsSearchFragment();
        }
    }
    public static class LyricsScreenRepresentation extends SupportAppScreen{
        private final String singer;
        private final  String song;
        public LyricsScreenRepresentation(String singer,String song){
            this.singer = singer;
            this.song = song;
        }
        @Nullable
        @Override
        public Fragment getFragment() {
             return LyricsFragment.getInstance(singer,song);

        }
    }

}
