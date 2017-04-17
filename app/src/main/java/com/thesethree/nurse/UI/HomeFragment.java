package com.thesethree.nurse.UI;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.thesethree.nurse.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Eric on 2017-4-10.
 */

public class HomeFragment extends Fragment {
    private static HomeFragment fragment;

    public static HomeFragment getInstance() {
        if (fragment == null)
            fragment = new HomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, null);

        GridView gridview = (GridView) view.findViewById(R.id.common_grid_view);
        GridViewInit(gridview);

        return view;
    }

    //首页轮播图初始化
    private void CarouselFigureInit(){

    }

    ///九宫格模块初始化
    private void GridViewInit(GridView gridview) {
        final int[] imageRes = {
                R.drawable.i6,
                R.drawable.i7,
                R.drawable.i8
        };
        final int[] name = {
                R.string.notice_title_item_grid_view,
                R.string.news_title_item_grid_view,
                R.string.more_title_item_grid_view
        };
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<>();
        for (int i = 0; i < imageRes.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("ItemImage", imageRes[i]);
            map.put("ItemText", getString(name[i]));
            lstImageItem.add(map);
        }

        SimpleAdapter saImageItems = new SimpleAdapter(getActivity(),
                lstImageItem,
                R.layout.item_grid_view,
                new String[]{"ItemImage", "ItemText"},
                new int[]{R.id.img_item_grid_view, R.id.txt_item_grid_view});
        gridview.setAdapter(saImageItems);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), getString(name[position])+",敬请期待......", Toast.LENGTH_LONG).show();
            }
        });
    }
}
