package com.example.rynel.contentprovider.MainActivity.di;

import android.content.Context;

import com.example.rynel.contentprovider.utils.DatabaseHelper;
import com.example.rynel.contentprovider.MainActivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;



//denote the module with @module annotation
@Module
public class MainActivityModule {

    //provides the MainActivityPresenter object by this method
    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }
    @Provides
    DatabaseHelper providesDatabaseHelper(Context context){return new DatabaseHelper(context);}
}
