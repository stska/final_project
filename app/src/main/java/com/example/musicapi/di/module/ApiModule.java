package com.example.musicapi.di.module;

import com.example.musicapi.mvp.model.api.IDataSoutce;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    @Named("rootUrl")
    @Provides
    String rootUrl() {
        return "https://api.musixmatch.com/ws/1.1/";
    }

    @Singleton
    @Provides
    Gson gson(){
        return  new GsonBuilder().setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation().create();
    }
    @Singleton
    @Provides
    IDataSoutce api(@Named("rootUrl") String rootUrl,Gson gson){
        return new Retrofit.Builder()
                .baseUrl("https://api.musixmatch.com/ws/1.1/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(IDataSoutce.class);
    }
}


