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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.system.myapplication.R;

public class Map extends AppCompatActivity {
    private static final String SAVED_PARCEL = "PARCEL";
    private final String TAG = this.getLocalClassName() ;
    private EditText editText;
    private ListView listView;
    private Button button;
    private MainParcel mainParcel;
    private TextView textView_1;
    private TextView textView_2;
    protected void onCreate(Bundle savedInstanceState)
    {   Intent mIntent= getIntent();
        mainParcel=mIntent.getParcelableExtra("KEY");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        button = findViewById(R.id.map_search_button);
        editText = findViewById(R.id.map_edit_text);
        listView = findViewById(R.id.map_listView_1);
        textView_1=findViewById(R.id.map_text1);
        textView_2=findViewById(R.id.map_text2);
        ArrayAdapter<String> adapter  =  new  ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,mainParcel.getList_1());
        listView.setAdapter(adapter);
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
textView_1.setText(mainParcel.getString1());
textView_2.setText(mainParcel.getString2());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_PARCEL, mainParcel);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mainParcel=savedInstanceState.getParcelable(SAVED_PARCEL);

        ArrayAdapter<String> adapter  =  new  ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,mainParcel.getList_1());
        listView.setAdapter(adapter);
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
