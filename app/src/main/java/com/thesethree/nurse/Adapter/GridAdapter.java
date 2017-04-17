package com.thesethree.nurse.Adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.thesethree.nurse.Bean.GridItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 2017-4-17.
 */

public class GridAdapter extends PagerAdapter {
    private List<GridItem> items;
    private List<SimpleDraweeView> images = new ArrayList<SimpleDraweeView>();

    public GridAdapter(Activity context, List<GridItem> items) {
        if (items == null || items.size() == 0) {
            this.items = new ArrayList<>();
        } else {
            this.items = items;
        }

        for (int i = 0; i < items.size(); i++) {
            SimpleDraweeView image = new SimpleDraweeView(context);
            Uri uri = Uri.parse(items.get(i).getImageUrl());
            image.setImageURI(uri);
            images.add(image);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
