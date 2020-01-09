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

public class Catalog extends AppCompatActivity {
    private MainParcel mainParcel;
    private final String TAG = this.getClass().getName() ;
    private Button button;
    private EditText editText;
    private ListView listView;
    private ListView listView_1;
    private List<String> list=new ArrayList<>();
    private List<String> list_1=new ArrayList<>();
    private static final String SAVED_PARCEL = "PARCEL";
    private static final String STRING_1= "string_1";
    private static final String STRING_2= "string_2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);
        button = findViewById(R.id.catalog_search_button);
        editText = findViewById(R.id.catalog_edit_text);
        listView = findViewById(R.id.catalog_listView_1);
        listView_1 =findViewById(R.id.catalog_listView_2);
        for (int i = 0; i < 5; i++)
        {
            list.add("Item"+ Math.round(10*Math.random()));
            list_1.add("Item"+Math.round(3+10*Math.random()));
        }
        mainParcel=new MainParcel();
        ArrayAdapter<String> adapter  =  new  ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,list);
        ArrayAdapter<String> adapter_1  =  new  ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,list_1);
        listView.setAdapter(adapter);
        listView_1.setAdapter(adapter_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
                    myIntent.putExtra("KEY",mainParcel);
                    startActivity(myIntent);
                    mainParcel.setList_1(list_1);
                    mainParcel.setString1(STRING_1);
                    mainParcel.setString2(STRING_2);

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
        mainParcel.setList_1(list);
        mainParcel.setList_2(list_1);
        outState.putParcelable(SAVED_PARCEL, mainParcel);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mainParcel=savedInstanceState.getParcelable(SAVED_PARCEL);
        list=mainParcel.getList_1();
        list_1=mainParcel.getList_2();
        ArrayAdapter<String> adapter  =  new  ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,list);
        ArrayAdapter<String> adapter_1  =  new  ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,list_1);
        listView.setAdapter(adapter);
        listView_1.setAdapter(adapter_1);
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


