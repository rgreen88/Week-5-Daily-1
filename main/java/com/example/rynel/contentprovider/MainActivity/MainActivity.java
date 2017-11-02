package com.example.rynel.contentprovider.MainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rynel.contentprovider.model.Person;
import com.example.rynel.contentprovider.utils.DatabaseHelper;
import com.example.rynel.contentprovider.R;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    EditText etFirstName, etLastName, etAge;
    DatabaseHelper databaseHelper;
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter();
        presenter.addView(this);
        databaseHelper = new DatabaseHelper(this);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAge = findViewById(R.id.etAge);

    }


    public void savePerson(View view) {
        presenter.populateDB(this,
                new Person(etFirstName.getText().toString(),
                        etLastName.getText().toString(),
                        etAge.getText().toString()));
        Toast.makeText(this, "Person saved to the annals of history!", Toast.LENGTH_SHORT).show();
    }
}
