package com.example.applinks;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ru.system.myapplication.R;

public class Search extends AppCompatActivity {
    private MainParcel mainParcel;
    private final String TAG = this.getClass().getName() ;
    private Button button;
    private EditText editText;

    private static final String SAVED_PARCEL = "PARCEL";
    private static final String STRING_1= "string_1";
    private static final String STRING_2= "string_2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        button = findViewById(R.id.search_search_button);
        editText = findViewById(R.id.search_edit_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
                    startActivity(myIntent);
                }
                catch (ActivityNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
           }

    @Override
    protected void onStop() {
        super.onStop();
          }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

}
