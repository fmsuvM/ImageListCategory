package com.example.fmsurvivor.imagelistcategory;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;


public class PhotoListAdapterThird extends BaseAdapter{

    private List<PhotoModel> mPhotoList;
    private Context mContext;

    public PhotoListAdapterThird(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return mPhotoList == null ? 0 : mPhotoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPhotoList == null ? null : mPhotoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        PhotoModel photo = mPhotoList.get(position);
        if(convertView == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_third, parent, false);
        } else{
            view = convertView;
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_third);


        Glide.with(mContext)
                .load(photo.getImageUrl())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Log.d("Glide", "Error in Glide Listener");
                        if(e != null){
                            e.printStackTrace();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .placeholder(R.drawable.tuusin_icon)
                .error(R.drawable.ic_launcher)
                .centerCrop()
                .crossFade()
                .into(imageView);

        TextView dateTextView = (TextView) view.findViewById(R.id.date_text_view_third);
        dateTextView.setText(photo.getDate().toString());

        TextView commentTextView = (TextView) view.findViewById(R.id.value_text_view_third);
        commentTextView.setText(photo.getText());

        return view;
    }

    public void  setPhotoList(List<PhotoModel> photoList){
        mPhotoList = photoList;
        notifyDataSetChanged();
    }
}
