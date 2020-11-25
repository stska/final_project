package com.example.musicapi.mvp.model.entity.lyricsRespond.checkHeaderResponse;

import com.example.musicapi.mvp.model.entity.lyricsRespond.Body;
import com.example.musicapi.mvp.model.entity.lyricsRespond.Header;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageStatus {
    @SerializedName("header")
    @Expose
    private Header header;

    public Header getHeaderStatusCode() {
        return header;
    }


}
