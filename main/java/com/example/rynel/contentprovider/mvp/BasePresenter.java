package com.example.rynel.contentprovider.mvp;

/**
 * Created by Admin on 10/23/2017.
 */

public interface BasePresenter <V extends BaseView> {
    void addView(V View);
    void removeView();
}
