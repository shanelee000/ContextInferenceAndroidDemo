package com.demo.shanelee.contextinference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.shanelee.contextinference.activity.DecisionTreeActivity;
import com.demo.shanelee.contextinference.activity.NaiveBayesActivity;
import com.demo.shanelee.contextinference.activity.TestDbActivity;
import com.demo.shanelee.contextinference.manager.DBManager;

public class MainActivity extends AppCompatActivity {

    public DBManager dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showTreeBtn = (Button) findViewById(R.id.show_tree);
        if(showTreeBtn != null){
            showTreeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DecisionTreeActivity.class);
                    startActivity(intent);
                }
            });
        }

        Button showBayesBtn = (Button) findViewById(R.id.show_bayes);
        if(showBayesBtn != null) {
            showBayesBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, NaiveBayesActivity.class);
                    startActivity(intent);
                }
            });
        }

//        Button showTestDbBtn = (Button) findViewById(R.id.show_test);
//        if(showTestDbBtn != null){
//            showTestDbBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(MainActivity.this, TestDbActivity.class);
//                    startActivity(intent);
//                }
//            });
//        }
    }
}
