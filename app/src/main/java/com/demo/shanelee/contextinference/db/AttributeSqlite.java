package com.demo.shanelee.contextinference.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.demo.shanelee.contextinference.R;
import com.demo.shanelee.contextinference.entity.AttributeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2016/5/23.
 */
public class AttributeSqlite {

    public static List<AttributeEntity> queryAll(Context context){
        List<AttributeEntity> list = new ArrayList<>();
        AttributeDbHelper helper = new AttributeDbHelper(context, "attribute.db", null, R.integer.db_version);
        SQLiteDatabase db = helper.getWritableDatabase();

        StringBuilder sb = new StringBuilder();
        Cursor cursor = db.query("attribute", null, null, null, null, null, null);
        //存在数据才返回true
        if(cursor.moveToFirst()){
            do {
                AttributeEntity attr = new AttributeEntity();
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String light = cursor.getString(cursor.getColumnIndex("light"));
                String sound = cursor.getString(cursor.getColumnIndex("sound"));
                String temperature = cursor.getString(cursor.getColumnIndex("temperature"));
                String humidity = cursor.getString(cursor.getColumnIndex("humidity"));
                String position = cursor.getString(cursor.getColumnIndex("position"));
                String movement = cursor.getString(cursor.getColumnIndex("movement"));
                String gps = cursor.getString(cursor.getColumnIndex("gps"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                String contextStr = cursor.getString(cursor.getColumnIndex("context"));

                attr.setId(id);
                attr.setLight(light);
                attr.setSound(sound);
                attr.setTemperature(temperature);
                attr.setHumidity(humidity);
                attr.setPosition(position);
                attr.setMovement(movement);
                attr.setGps(gps);
                attr.setTime(time);
                attr.setContext(contextStr);

                list.add(attr);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public static boolean insert(Context context, AttributeEntity attr){
        AttributeDbHelper helper = new AttributeDbHelper(context, "attribute.db", null, R.integer.db_version);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("light", attr.getLight());
        values.put("sound", attr.getSound());
        values.put("temperature", attr.getTemperature());
        values.put("humidity", attr.getHumidity());
        values.put("position", attr.getPosition());
        values.put("movement", attr.getMovement());
        values.put("gps", attr.getGps());
        values.put("time", attr.getTime());
        values.put("context", attr.getContext());

        //参数依次是：表名，强行插入null值得数据列的列名，一行记录的数据
        try {
            db.insert("person", null, values);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
