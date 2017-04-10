package com.thesethree.nurse.UI;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.thesethree.nurse.LoginActivity;
import com.thesethree.nurse.R;
import com.thesethree.nurse.Utils.ContextUtils;

/**
 * Created by Eric on 2017-4-10.
 */

public class PersonalFragment extends Fragment {

    private static PersonalFragment fragment;

    public static PersonalFragment getInstance() {
        if (fragment == null)
            fragment = new PersonalFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal, null);
        Button loginButton= (Button) view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ContextUtils.getInstance(), LoginActivity.class);
                getActivity().startActivityForResult(intent, Activity.RESULT_FIRST_USER);
            }
        });
        return view;
    }
}
