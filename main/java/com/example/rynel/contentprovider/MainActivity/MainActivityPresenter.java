package com.example.rynel.contentprovider.MainActivity;

import android.content.Context;

import com.example.rynel.contentprovider.utils.DatabaseHelper;
import com.example.rynel.contentprovider.model.Person;



public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    @Override
    public void addView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {

    }

    public void populateDB(Context context, Person person){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);

        databaseHelper.savePerson(person);


    }

}
