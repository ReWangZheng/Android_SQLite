package com.example.wz.sqlitedemo1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by 王正 on 2019/2/5.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL="create table Book(id integer primary key autoincrement,author text,price real,pages integer,name text)";

    private Context mcontext;
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context,name,factory,version);
        mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL);
        Toast.makeText(mcontext, "创建成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
