package com.thesethree.nurse.UI;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thesethree.nurse.R;

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
        return view;
    }
}
