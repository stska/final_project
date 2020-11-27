package com.example.musicapi.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.R;
import com.example.musicapi.mvp.presenter.CountryPickPresenter;
import com.example.musicapi.mvp.view.CountryPickView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class CountryPickFragment extends MvpAppCompatFragment implements CountryPickView, AdapterView.OnItemClickListener {

    View view;
    @InjectPresenter
    CountryPickPresenter presenter;
    private HashMap<String,String> map;
    private  AutoCompleteTextView  textView;
    private Button searchBtn;
    private final String WRONG_WRITTEN_COUNTRY = "Wrong country,please choose from the given list";
    private final String COUNTRY_NOT_FOUND = "No country is found";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       view = inflater.inflate(R.layout.fragment_countries,container,false);
       searchBtn = view.findViewById(R.id.searchTopCtBtn);
       searchBtn.setOnClickListener(view -> {
           String givenCountry = textView.getText().toString();
           if(!givenCountry.isEmpty()){
               String ct = getCountryCode(givenCountry);
               if(!ct.isEmpty()) {
                   presenter.pickCountryFromArray(ct);
               } Toast.makeText(getContext(),WRONG_WRITTEN_COUNTRY,Toast.LENGTH_LONG).show();
           }else Toast.makeText(getContext(),COUNTRY_NOT_FOUND,Toast.LENGTH_LONG).show();
       });
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MusicInfoApplication.getAppContext(),android.R.layout.simple_spinner_dropdown_item, initListOfCountries());
        textView = (AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);
        textView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void init() {

    }
    private ArrayList<String> initListOfCountries(){
        Writer writer = new StringWriter();
        BufferedReader reader = new BufferedReader((new InputStreamReader(getResources().openRawResource(R.raw.countrycode)))) ;
        try{
            String line = reader.readLine();
            while(line != null){
                writer.write(line);
                line = reader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        map = new Gson().fromJson(String.valueOf(writer), new TypeToken<HashMap<String,String>>(){}.getType());
        ArrayList<String> countries = new ArrayList<>();
        Set<Map.Entry<String, String>> ctEntry = map.entrySet();          //TODO проверить дургой метод
        ArrayList<Map.Entry<String, String>> countriesListOfEntry = new ArrayList<>(ctEntry);
        for(Map.Entry<String,String> entry: countriesListOfEntry){
            countries.add(entry.getValue());
        }
        return countries;
    }
  private String getCountryCode(String ct){
      Set<Map.Entry<String, String>> ctEntry = map.entrySet();
      for(Map.Entry<String,String> entry: ctEntry){
          if(entry.getValue().equals(ct)){
              return entry.getKey();
          }
      }
      return "";
  }

    @Override
 public void setArtName(String name) {

 }

 @Override
 public void setArtScore(String score) {

 }

 @Override
 public void setArtSongName(String songName) {

 }

    @Override
    public void updateList() {

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String ctCode = getCountryCode( adapterView.getItemAtPosition(position).toString());
        if(!ctCode.isEmpty()){
            presenter.pickCountryFromArray(ctCode);
        }
    }
}
