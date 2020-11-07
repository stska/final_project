package com.example.musicapi.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.musicapi.MusicInfoApplication;
import com.example.musicapi.R;
import com.example.musicapi.mvp.model.presenter.CountryPickPresenter;
import com.example.musicapi.mvp.view.CountryPickView;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class CountryPickFragment extends MvpAppCompatFragment implements CountryPickView, AdapterView.OnItemClickListener {
   // AutoCompleteTextView textView;
    View view;
    @InjectPresenter
    CountryPickPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
       view = inflater.inflate(R.layout.fragment_countries,container,false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MusicInfoApplication.getAppContext(),android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView    textView = (AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);
        textView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void init() {
       // ArrayAdapter<String> testAdap = new ArrayAdapter<String>(MusicInfoApplication.getAppContext(),android.R.layout.simple_dropdown_item_1line, COUNTRIES);
     //   ArrayAdapter<String> adapter = new ArrayAdapter<>(MusicInfoApplication.getAppContext(),android.R.layout.simple_dropdown_item_1line, COUNTRIES);
     //   AutoCompleteTextView    textView = (AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextView);
     //   textView.setAdapter(adapter);
      //  textView.setOnItemClickListener(this);
    }

    @Override
    public void updateList() {

    }


    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "it", "Germany", "Spain","Slovenia","Slovakia","ru","usa","uk"
    };

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        presenter.pickCountryFromArray(adapterView.getItemAtPosition(position).toString());
    }
}
