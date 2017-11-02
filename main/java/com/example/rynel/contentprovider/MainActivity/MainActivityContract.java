package com.example.rynel.contentprovider.MainActivity;

import com.example.rynel.contentprovider.mvp.BasePresenter;
import com.example.rynel.contentprovider.mvp.BaseView;


public interface MainActivityContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {

    }
}
