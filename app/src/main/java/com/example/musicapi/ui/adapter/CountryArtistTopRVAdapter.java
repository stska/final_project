package com.example.musicapi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapi.R;
import com.example.musicapi.mvp.model.presenter.list.ICountryTopItemView;
import com.example.musicapi.mvp.model.presenter.list.ICountryTopListPresenter;

public class CountryArtistTopRVAdapter extends RecyclerView.Adapter<CountryArtistTopRVAdapter.ViewHolder> {
      private final ICountryTopListPresenter presenter;
      public CountryArtistTopRVAdapter(ICountryTopListPresenter presenter) {
          this.presenter = presenter;
      }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.country_top_artists_item_old,parent,false);
        return new ViewHolder(userView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          holder.position = position;
          holder.itemView.setOnClickListener(view -> {
              presenter.onItemClick(holder);        ///////TODO проверить с view
          });
          presenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
       return presenter.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements ICountryTopItemView {
        TextView artist;
        TextView artistTitle;
        TextView score;
        TextView twitter;
        int position;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artist = itemView.findViewById(R.id.artistName);
            score = itemView.findViewById(R.id.score);
            twitter = itemView.findViewById(R.id.twitterInfo);
           // artistTitle = itemView.findViewById(R.id.artistTitle);
        }

        @Override
        public void setArtName(String name) {
            artist.setText(name);
          //  artistTitle.setText("Artist");
        }

        @Override
        public void setArtScore(String scores) {
            score.setText(scores);
        }

        @Override
        public void setArtTwitter(String twitURL) {
            twitter.setText(twitURL);
        }

        @Override
        public int getPos() {
            return position;
        }
    }
}
