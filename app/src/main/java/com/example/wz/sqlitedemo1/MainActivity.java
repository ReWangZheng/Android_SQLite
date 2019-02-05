package com.example.wz.sqlitedemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Button button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 DatabaseHelper helper=new DatabaseHelper(MainActivity.this,"dbStu",null,4);
                helper.getWritableDatabase();
            }
        });

    }
}
