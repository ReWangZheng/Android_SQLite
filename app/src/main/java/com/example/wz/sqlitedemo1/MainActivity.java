package com.example.wz.sqlitedemo1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper=new DatabaseHelper(MainActivity.this,"dbStu",null,4);
                SQLiteDatabase sqld=databaseHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("author","Regan");
                values.put("price",98.6);
                values.put("pages",764);
                values.put("name","《C primer plus》");
                sqld.insert("Book",null,values);
            }
        });

        Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sdb=new DatabaseHelper(MainActivity.this,"dbStu",null,4).getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name","《JAVA》");
                sdb.update("Book",values,"name=?",new String[]{"《C primer plus》"});

            }
        });



    }
}
