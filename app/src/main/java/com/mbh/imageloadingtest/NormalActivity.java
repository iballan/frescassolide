package com.mbh.imageloadingtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class NormalActivity extends AppCompatActivity {

    ListView lv_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        lv_images = (ListView) findViewById(R.id.lv_images);

        lv_images.setAdapter(new NormalBaseAdapter(this));
    }


    class NormalBaseAdapter extends BaseAdapter {

        LayoutInflater inflater;
        public NormalBaseAdapter(Context context){
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return Commons.getItemsList().size();
        }

        @Override
        public Object getItem(int position) {
            return Commons.getItemsList().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyViewHolder viewHolder;
            if(convertView == null){
                convertView = inflater.inflate(R.layout.item_with_imageview, parent, false);
                viewHolder = new MyViewHolder(convertView);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (MyViewHolder) convertView.getTag();
            }

            ImageTextItem imageTextItem = Commons.getItemsList().get(position);

            viewHolder.tv_text.setText(imageTextItem.Text);
            viewHolder.iv_background.setBackgroundResource(imageTextItem.ImageId);
            return convertView;
        }

        private class MyViewHolder {
            TextView tv_text;
            ImageView iv_background;

            public MyViewHolder(View item) {
                tv_text = (TextView) item.findViewById(R.id.tv_text);
                iv_background = (ImageView) item.findViewById(R.id.iv_background);
            }
        }
    }
}
