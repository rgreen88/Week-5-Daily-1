package com.example.rynel.contentprovider.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.rynel.contentprovider.model.Person;

import java.util.ArrayList;
import java.util.List;



public class DatabaseHelper extends SQLiteOpenHelper {

    //creating table values
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "Person.db";

    private static final String TABLE_NAME = "Person";
    private static final String COLUMN_FIRST_NAME = "FirstName";
    private static final String COLUMN_LAST_NAME = "LastName";
    private static final String COLUMN_AGE = "Age";
    private static final String ID = "id";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //creating actual table based on above values
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY, " +
                COLUMN_FIRST_NAME + " TEXT, " + COLUMN_LAST_NAME + " TEXT, " + COLUMN_AGE +
                " TEXT " + ")";
        db.execSQL(CREATE_TABLE);
    }

    //version upgrade per update
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long savePerson(Person person){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, person.getFirstName());
        contentValues.put(COLUMN_LAST_NAME, person.getLastName());
        contentValues.put(COLUMN_AGE, person.getAge());

        return database.insert(TABLE_NAME, null, contentValues);
    }

    public List<Person> getPersonList(){
        List<Person> personArrayList = new ArrayList<>();

        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "SELECT * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(QUERY, null);
        cursor.close();


        if(cursor.moveToFirst()){
            do{
                Person person = new Person(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2));
                personArrayList.add(person);
            }while (cursor.moveToNext());
        }

        return personArrayList;
    }
}
