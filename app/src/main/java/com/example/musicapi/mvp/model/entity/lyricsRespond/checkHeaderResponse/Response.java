package com.example.musicapi.mvp.model.entity.lyricsRespond.checkHeaderResponse;

import com.example.musicapi.mvp.model.entity.lyricsRespond.Message;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("message")
    @Expose
    private MessageStatus message;

    public MessageStatus getMessageStatus() {
        return message;
    }

    public void setMessage(MessageStatus message) {
        this.message = message;
    }
}
//Специально для запроса статуса, иначе крашится. У апи ответ отличается параметром боди, при ощибке, он присылает боди как Array, а не обЪект, из-за этого все падает. пришлось делать отдельные классы и вначале проверять ошибку