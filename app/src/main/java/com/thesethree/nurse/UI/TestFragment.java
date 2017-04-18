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

import com.thesethree.nurse.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Eric on 2017-4-10.
 */

public class TestFragment extends Fragment {
    private static TestFragment fragment;

    public static TestFragment getInstance() {
        if (fragment == null)
            fragment = new TestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test, null);

        GridView gridview = (GridView) view.findViewById(R.id.test_common_grid_view);
        GridViewInit(gridview);

        return view;
    }

    private void GridViewInit(GridView gridview) {
        final int[] imageRes = {
                R.drawable.i3,
                R.drawable.i4,
                R.drawable.i5
        };
        final String[] name = {
                "三基考试",
                "司机考试",
                "无极考试"
        };
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<>();
        for (int i = 0; i < imageRes.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("ItemImage", imageRes[i]);
            map.put("ItemText", name[i]);
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

            }
        });
    }
}
