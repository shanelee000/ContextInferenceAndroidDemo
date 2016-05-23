package com.demo.shanelee.contextinference.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.shanelee.contextinference.MainActivity;
import com.demo.shanelee.contextinference.R;

/**
 * Created by lx on 2016/5/23.
 */
public class NaiveBayesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naive_bayes);

        Button trainDataBtn = (Button) findViewById(R.id.train_data);
        if (trainDataBtn != null){
            trainDataBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(NaiveBayesActivity.this, "训练数据完毕", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
