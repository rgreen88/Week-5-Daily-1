package com.example.rynel.contentprovider.MainActivity.di;

import com.example.rynel.contentprovider.MainActivity.MainActivity;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
