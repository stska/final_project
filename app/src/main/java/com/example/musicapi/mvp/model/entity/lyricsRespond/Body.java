
package com.example.musicapi.mvp.model.entity.lyricsRespond;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Body {

    @SerializedName("lyrics")
    @Expose
    private Lyrics lyrics;

    public Lyrics getLyrics() {
        return lyrics;
    }

    public void setLyrics(Lyrics lyrics) {
        this.lyrics = lyrics;
    }

}
