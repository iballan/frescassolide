package com.mbh.imageloadingtest;

import android.content.Context;
import android.net.Uri;

import com.facebook.common.util.UriUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * CreatedBy MBH on 2016-03-17.
 */
public class Commons {


    private static final int REPEAT_COUNT = 3;
    private static List<ImageTextItem> itemsList = null;

    public static List<ImageTextItem> getItemsList(){
        if(itemsList != null) return itemsList;
        itemsList = new ArrayList<>();

        int[] ImagesArray = new int[]{
                R.drawable.blue, R.drawable.fog,
                R.drawable.stairs, R.drawable.under_bridge,
                R.drawable.windows, R.drawable.snow};
        String[] TextsArray = new String[] {
                "Blue", "Fog",
                "Stairs", "Under Bridge",
                "Windows", "Snow"};

        for (int i = 0; i < REPEAT_COUNT; i++) {
            for (int j = 0; j < ImagesArray.length; j++) {
                ImageTextItem item = new ImageTextItem();
                item.ImageId = ImagesArray[j];
                item.Text = TextsArray[j];
                itemsList.add(item);
            }

        }
        return itemsList;
    }

    public static Uri getResourceUri(Context context, int resID) {
        return new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resID))
                .build();
//        return Uri.parse("android.resource://"+context.getPackageName()+"/"+resID);
//        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
//                context.getResources().getResourcePackageName(resID) + '/' +
//                context.getResources().getResourceTypeName(resID) + '/' +
//                context.getResources().getResourceEntryName(resID) );
    }
}
