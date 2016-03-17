package com.mbh.imageloadingtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * CreatedBy MBH on 2016-03-17.
 */
public class FrescoActivity extends AppCompatActivity {

    ListView lv_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        lv_images = (ListView) findViewById(R.id.lv_images);

        lv_images.setAdapter(new FrescoBaseAdapter(this));
    }


    class FrescoBaseAdapter extends BaseAdapter {

        LayoutInflater inflater;
        Context context;
        public FrescoBaseAdapter(Context context){
            this.context = context;
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
                convertView = inflater.inflate(R.layout.item_with_fresco, parent, false);
                viewHolder = new MyViewHolder(convertView);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (MyViewHolder) convertView.getTag();
            }

            ImageTextItem imageTextItem = Commons.getItemsList().get(position);

            viewHolder.tv_text.setText(imageTextItem.Text);
            int width = parent.getWidth();

            Uri imageUri = Commons.getResourceUri(context, imageTextItem.ImageId);
            viewHolder.drawee_frescoBackground.setImageURI(imageUri);
            return convertView;
        }

        private class MyViewHolder {
            TextView tv_text;
            SimpleDraweeView drawee_frescoBackground;

            public MyViewHolder(View item) {
                tv_text = (TextView) item.findViewById(R.id.tv_text);
                drawee_frescoBackground = (SimpleDraweeView)
                        item.findViewById(R.id.drawee_frescoBackground);
            }
        }
    }
}