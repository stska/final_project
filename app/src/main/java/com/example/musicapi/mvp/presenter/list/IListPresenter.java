package com.example.musicapi.mvp.presenter.list;

public interface IListPresenter <V extends IItemView>{
    void onItemClick(V view);
    void bindView(V view);
    int getCount();
}
