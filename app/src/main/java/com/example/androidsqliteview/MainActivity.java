package com.example.androidsqliteview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button insert, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = (Button) findViewById(R.id.insert);
        view = (Button) findViewById(R.id.view);

        insert.setOnClickListener(this::onClick);
        view.setOnClickListener(this::onClick);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insert:
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(intent);
                break;

            case R.id.view:
                Intent intent1 = new Intent(MainActivity.this, DataListActivity.class);
                startActivity(intent1);
                break;
        }
    }

}