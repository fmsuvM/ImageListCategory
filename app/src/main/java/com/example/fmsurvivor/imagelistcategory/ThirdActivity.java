package com.example.fmsurvivor.imagelistcategory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    PhotoListAdapterThird tPhotoListAdapter;
    List<PhotoModel> tPhotoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button Tgreat_button = (Button) findViewById(R.id.Tgreat_button);

        tPhotoListAdapter = new PhotoListAdapterThird(this);

        ListView listview = (ListView)findViewById((R.id.list_view_third));
        listview.setAdapter(tPhotoListAdapter);

        tPhotoList = new ArrayList<>();

        Tgreat_button.setOnClickListener(this);

        //これは最初に表示されている画像
        tPhotoList.add(new PhotoModel(/*右文字列に取得したい画像のURLを入れる. 今は適当なURL*/"hogehoge.png", new Date(), "Test Third Text"));
        tPhotoListAdapter.setPhotoList(tPhotoList);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Tgreat_button:
                //追加する画像
                tPhotoList.add(0, new PhotoModel(/*右文字列に取得したい画像のURLを入れる. 今は適当なURL*/"hugahuga.png", new Date(), "Test Additional Third Text"));
                tPhotoListAdapter.setPhotoList(tPhotoList);
                break;
        }
    }
}
