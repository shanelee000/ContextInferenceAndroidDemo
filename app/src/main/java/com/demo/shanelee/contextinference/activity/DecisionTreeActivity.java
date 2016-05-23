package com.demo.shanelee.contextinference.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.shanelee.contextinference.R;

/**
 * Created by lx on 2016/5/23.
 */
public class DecisionTreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decision_tree);

        Button getTreeBtn = (Button) findViewById(R.id.get_tree);
        if(getTreeBtn != null){
            getTreeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(DecisionTreeActivity.this, "构造完成", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button startBtn = (Button) findViewById(R.id.start);
        if(startBtn != null){
            startBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 2016/5/24 获取当前传感器分类数据 进行分析 
                }
            });
        }
    }
}
