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

public class CourseFragment extends Fragment {
    private static CourseFragment fragment;

    public static CourseFragment getInstance() {
        if (fragment == null)
            fragment = new CourseFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course, null);
        return view;
    }
}
