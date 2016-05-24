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
                "  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\n" +
                "  `light` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `sound` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `temperature` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `humidity` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `position` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `movement` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `gps` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `time` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `context` varchar(255) NOT NULL DEFAULT '');";

        db.execSQL(createSql);

        db.execSQL("INSERT INTO `attribute` VALUES ('1', 'very dark', 'normal', 'normal', 'medium', 'lying', 'not moving', '', '', 'resting')," +
                "('2', 'very dark', 'quiet', 'normal', 'medium', 'lying', 'not moving', '', '', 'resting')," +
                "('3', 'very dark', 'normal', 'normal', 'high', 'lying', 'not moving', '', '', 'resting')," +
                "('4', 'very dark', 'normal', 'normal', 'medium', 'lying', 'moving', '', '', 'resting')," +
                "('5', 'very bright', 'normal', 'normal', 'medium', 'standing', 'not moving', '', '', 'idle')," +
                "('6', 'very bright', 'quiet', 'normal', 'medium', 'standing', 'not moving', '', '', 'idle')," +
                "('8', 'very bright', 'quiet', 'normal', 'medium', 'standing', 'moving', '', '', 'idle')," +
                "('9', 'very dark', 'normal', 'normal', 'high', 'lying', 'moving', '', '', 'resting')," +
                "('10', 'very dark', 'quiet', 'normal', 'high', 'lying', 'not moving', '', '', 'resting')," +
                "('11', 'very dark', 'quiet', 'normal', 'medium', 'lying', 'moving', '', '', 'resting')," +
                "('12', 'very dark', 'quiet', 'normal', 'high', 'lying', 'moving', '', '', 'resting')," +
                "('13', 'very bright', 'normal', 'normal', 'medium', 'lying', 'moving', '', '', 'walking')," +
                "('14', 'very bright', 'normal', 'normal', 'medium', 'lying', 'moving fast', '', '', 'walking')," +
                "('15', 'very bright', 'normal', 'normal', 'medium', 'standing', 'moving', '', '', 'walking')," +
                "('16', 'very bright', 'normal', 'normal', 'medium', 'standing', 'moving fast', '', '', 'walking')," +
                "('17', 'very bright', 'normal', 'normal', 'high', 'lying', 'moving', '', '', 'walking')," +
                "('18', 'very bright', 'normal', 'normal', 'high', 'lying', 'moving fast', '', '', 'walking')," +
                "('19', 'very bright', 'normal', 'normal', 'high', 'standing', 'moving', '', '', 'walking')," +
                "('20', 'very bright', 'normal', 'normal', 'high', 'standing', 'moving fast', '', '', 'walking')," +
                "('21', 'very bright', 'loud', 'normal', 'medium', 'lying', 'moving', '', '', 'running')," +
                "('22', 'very bright', 'loud', 'normal', 'medium', 'lying', 'moving fast', '', '', 'running')," +
                "('23', 'very bright', 'loud', 'normal', 'medium', 'standing', 'moving', '', '', 'running')," +
                "('24', 'very bright', 'loud', 'normal', 'medium', 'standing', 'moving fast', '', '', 'running')," +
                "('25', 'very bright', 'loud', 'normal', 'high', 'lying', 'moving', '', '', 'running')," +
                "('26', 'very bright', 'loud', 'normal', 'high', 'lying', 'moving fast', '', '', 'running')," +
                "('27', 'very bright', 'loud', 'normal', 'high', 'standing', 'moving', '', '', 'running')," +
                "('28', 'very bright', 'loud', 'normal', 'high', 'standing', 'moving fast', '', '', 'running')," +
                "('29', 'very bright', 'loud', 'hot', 'medium', 'lying', 'moving', '', '', 'running')," +
                "('30', 'very bright', 'loud', 'hot', 'medium', 'lying', 'moving fast', '', '', 'running')," +
                "('31', 'very bright', 'loud', 'hot', 'medium', 'standing', 'moving', '', '', 'running')," +
                "('32', 'very bright', 'loud', 'hot', 'medium', 'standing', 'moving fast', '', '', 'running')," +
                "('33', 'very bright', 'loud', 'hot', 'high', 'lying', 'moving', '', '', 'running')," +
                "('34', 'very bright', 'loud', 'hot', 'high', 'lying', 'moving fast', '', '', 'running')," +
                "('35', 'very bright', 'loud', 'hot', 'high', 'standing', 'moving', '', '', 'running')," +
                "('36', 'very bright', 'loud', 'hot', 'high', 'standing', 'moving fast', '', '', 'running');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
