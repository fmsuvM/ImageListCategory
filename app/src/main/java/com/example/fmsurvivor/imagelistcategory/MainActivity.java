package com.example.fmsurvivor.imagelistcategory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    //MainActivityのcodeはCategory選択のみのcode
    //実際の遷移した画面の動作codeはSecondActivityとThirdActivity


    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        //リスト一覧
        adapter.add("To secondActivity");
        adapter.add("To thirdActivity");
        ListView listView = (ListView) findViewById(R.id.listview1);
        //ArrayAdapterをセット
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, ThirdActivity.class));
                break;

        }
    }
}
