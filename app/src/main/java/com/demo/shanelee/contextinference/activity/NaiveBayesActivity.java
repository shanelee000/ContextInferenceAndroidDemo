package com.demo.shanelee.contextinference.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.shanelee.contextinference.MainActivity;
import com.demo.shanelee.contextinference.R;
import com.demo.shanelee.contextinference.db.AttributeSqlite;
import com.demo.shanelee.contextinference.entity.AttributeEntity;
import com.demo.shanelee.contextinference.utils.NaiveBayesUtil;

/**
 * Created by lx on 2016/5/23.
 */
public class NaiveBayesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naive_bayes);

        Button trainDataBtn = (Button) findViewById(R.id.train_data);
        if (trainDataBtn != null) {
            trainDataBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(NaiveBayesActivity.this, TrainDataActivity.class);
                    startActivity(intent);
//                    Toast.makeText(NaiveBayesActivity.this, "训练数据完毕", Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button startBtn = (Button) findViewById(R.id.start);
        if (startBtn != null) {
            startBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 2016/5/24 每隔5或10秒钟取蓝牙数据
                    //假数据
                    AttributeEntity entity = new AttributeEntity();
                    entity.setLight("very dark");
                    entity.setSound("normal");
                    entity.setTemperature("normal");
                    entity.setHumidity("medium");
                    entity.setPosition("lying");
                    entity.setMovement("moving");
                    entity.setGps("outdoor");
                    entity.setTime("afternoon");

                    TextView lightView = (TextView) findViewById(R.id.light);
                    if(lightView != null){
                        lightView.setText(getResources().getString(R.string.light) + entity.getLight());
                    }
                    TextView soundView = (TextView) findViewById(R.id.sound);
                    if(soundView != null){
                        soundView.setText(getResources().getString(R.string.sound) + entity.getSound());
                    }
                    TextView tempView = (TextView) findViewById(R.id.temperature);
                    if(tempView != null){
                        tempView.setText(getResources().getString(R.string.temperature) + entity.getTemperature());
                    }
                    TextView humidityView = (TextView) findViewById(R.id.humidity);
                    if(humidityView != null){
                        humidityView.setText(getResources().getString(R.string.humidity) + entity.getHumidity());
                    }
                    TextView positionView = (TextView) findViewById(R.id.position);
                    if(positionView != null){
                        positionView.setText(getResources().getString(R.string.position) + entity.getPosition());
                    }
                    TextView movementView = (TextView) findViewById(R.id.movement);
                    if(movementView != null){
                        movementView.setText(getResources().getString(R.string.movement) + entity.getMovement());
                    }
                    TextView gpsView = (TextView) findViewById(R.id.gps);
                    if(gpsView != null){
                        gpsView.setText(getResources().getString(R.string.gps) + entity.getGps());
                    }
                    TextView timeView = (TextView) findViewById(R.id.time);
                    if(timeView != null){
                        timeView.setText(getResources().getString(R.string.time) + entity.getTime());
                    }

                    NaiveBayesUtil.handleTrainingData(AttributeSqlite.queryAll(NaiveBayesActivity.this));
                    String context = NaiveBayesUtil.inferContext(entity);

                    ImageView imgView = (ImageView) findViewById(R.id.img);
                    TextView imgText = (TextView) findViewById(R.id.img_text);
                    if (imgView != null && imgText != null) {
                        if("walking".equals(context)){
                            imgView.setImageResource(R.drawable.walking);
                            imgText.setText(R.string.walking);
                        }else if("running".equals(context)){
                            imgView.setImageResource(R.drawable.running);
                            imgText.setText(R.string.running);
                        }else if("idle".equals(context)){
                            imgView.setImageResource(R.drawable.idle);
                            imgText.setText(R.string.idle);
                        }else if("resting".equals(context)){
                            imgView.setImageResource(R.drawable.resting);
                            imgText.setText(R.string.resting);
                        }
                    }
                }
            });
        }
    }
}
