package com.demo.shanelee.contextinference.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.demo.shanelee.contextinference.entity.AttributeEntity;

import java.util.List;

/**
 * Created by lx on 2016/5/23.
 */
public class AttributeDbHelper extends SQLiteOpenHelper {
    public AttributeDbHelper(Context context, String name, CursorFactory cursorFactory, int version) {
        super(context,name,cursorFactory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
