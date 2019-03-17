package com.example.home1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.view.*;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    TextView mainTextView;
    Button button;
    int count = 0;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    EditText mainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.main_button);
        mainEditText = (EditText) findViewById(R.id.main_edittext);
        mainTextView = findViewById(R.id.main_textview);
        mainListView = findViewById(R.id.main_listview);
        mainListView.setOnItemClickListener(this);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
        mainListView.setAdapter(mArrayAdapter);
        button.setOnClickListener(this);
        mainTextView.setText("Set in Java!");
    }
    @Override
    public void onClick(View v){
        String name = mainEditText.getText().toString();
        if(!mNameList.contains(name)){
            mNameList.add(name);
            Collections.sort(mNameList);
        }
        mArrayAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mNameList.remove(position);
        mArrayAdapter.notifyDataSetChanged();
    }
}
