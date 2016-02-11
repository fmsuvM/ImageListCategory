package com.example.fmsurvivor.imagelistcategory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    PhotoListAdapterSecond sPhotoListAdapter;
    List<PhotoModel> sPhotoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button Sgreat_button = (Button)findViewById(R.id.Sgreat_button);
        sPhotoListAdapter = new PhotoListAdapterSecond(this);

        ListView slistview = (ListView)findViewById(R.id.list_view_second);
        slistview.setAdapter(sPhotoListAdapter);

        sPhotoList = new ArrayList<>();

        Sgreat_button.setOnClickListener(this);

        //これは最初に表示されている画像
        sPhotoList.add(new PhotoModel(/*右文字列に取得したい画像のURLを入れる. 今は適当なURL*/"hogehoge.png", new Date(), "Test Second Text"));
        sPhotoListAdapter.setPhotoList(sPhotoList);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Sgreat_button:
                //追加する画像
                sPhotoList.add(0, new PhotoModel(/*右文字列に取得したい画像のURLを入れる. 今は適当なURL*/"hugahuga.png", new Date(), "Test additional second text"));
                sPhotoListAdapter.setPhotoList(sPhotoList);
                break;
        }
    }
}
