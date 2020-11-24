package com.example.musicapi.mvp.model.presenter.list;

public interface IListPresenter <V extends IItemView>{
    void onItemClick(V view);
    void bindView(V view);
    int getCount();
}
