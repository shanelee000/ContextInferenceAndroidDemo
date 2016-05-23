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

        String createSql = "CREATE TABLE `attribute` (\n" +
                "  `id` int(11) PRIMARY KEY NOT NULL AUTOINCREMENT,\n" +
                "  `light` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `sound` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `temperature` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `humidity` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `position` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `movement` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `gps` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `time` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `context` varchar(255) NOT NULL DEFAULT '')";

        db.execSQL(createSql.toUpperCase());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
