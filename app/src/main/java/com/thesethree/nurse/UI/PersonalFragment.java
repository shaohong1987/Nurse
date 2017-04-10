package com.thesethree.nurse.UI;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.thesethree.nurse.LoginActivity;
import com.thesethree.nurse.R;
import com.thesethree.nurse.Utils.ConfigUtils;
import com.thesethree.nurse.Utils.ContextUtils;

/**
 * Created by Eric on 2017-4-10.
 */

public class PersonalFragment extends Fragment {

    private static PersonalFragment fragment;

    //通过 flag 标识什么时候需要强制重新实例化
    public static PersonalFragment getInstance(boolean flag) {
        if (fragment == null||flag)
            fragment = new PersonalFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal, null);


        if(ConfigUtils.isLogin){
            Button v= (Button) view.findViewById(R.id.login_button);
            v.setVisibility(View.GONE);
            Button loginOutBtn= (Button) view.findViewById(R.id.login_out_button);
            loginOutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            loginOutBtn.setVisibility(View.VISIBLE);
        }
        else{
            ViewGroup infoV= (ViewGroup) view.findViewById(R.id.personal_info_layout);
            infoV.setVisibility(View.GONE);
            ViewGroup infoMenuV= (ViewGroup) view.findViewById(R.id.personal_info_menu_layout);
            infoMenuV.setVisibility(View.GONE);
            Button loginButton= (Button) view.findViewById(R.id.login_button);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ContextUtils.getInstance(), LoginActivity.class);
                    getActivity().startActivityForResult(intent, ConfigUtils.LOGIN_REQUEST_CODE);
                }
            });
        }

        return view;
    }
}
