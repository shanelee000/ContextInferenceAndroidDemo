package com.demo.shanelee.contextinference.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.shanelee.contextinference.R;
import com.demo.shanelee.contextinference.db.AttributeDbHelper;

/**
 * Created by lx on 2016/5/24.
 */
public class TestDbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_db);
        AttributeDbHelper helper = new AttributeDbHelper(TestDbActivity.this, "attribute.db", null, 2);
        final SQLiteDatabase db = helper.getWritableDatabase();

        Button queryBtn = (Button) findViewById(R.id.query_all);
        if(queryBtn != null){
            queryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StringBuilder sb = new StringBuilder();
                    Cursor cursor = db.query("attribute", null, null, null, null, null, null);
                    //存在数据才返回true
                    if(cursor.moveToFirst()){
                         do {
                            int id = cursor.getInt(cursor.getColumnIndex("id"));
                            String context = cursor.getString(cursor.getColumnIndex("context"));
                            sb.append(id + "_" + context + "\n");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                    Toast.makeText(TestDbActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button countBtn = (Button) findViewById(R.id.count);
        if(countBtn != null){
            countBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor cursor =  db.rawQuery("SELECT COUNT (*) FROM attribute",null);
                    cursor.moveToFirst();
                    long result = cursor.getLong(0) + 1;
                    cursor.close();
                    Toast.makeText(TestDbActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button insertBtn = (Button) findViewById(R.id.insert);
        if(insertBtn != null){
            insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
                    Toast.makeText(TestDbActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button createBtn = (Button) findViewById(R.id.create);
        if(createBtn != null){
            createBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
                }
            });
        }

        Button deleteBtn = (Button) findViewById(R.id.delete);
        if(deleteBtn != null){
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }
}
