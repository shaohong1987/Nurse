package com.thesethree.nurse.UI;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.thesethree.nurse.CommonActivity;
import com.thesethree.nurse.LoginActivity;
import com.thesethree.nurse.R;
import com.thesethree.nurse.Utils.ConfigUtils;
import com.thesethree.nurse.Utils.ContextUtils;

public class PersonalFragment extends Fragment implements View.OnClickListener {

    private static PersonalFragment fragment;

    //通过 flag 标识什么时候需要强制重新实例化
    public static PersonalFragment getInstance(boolean flag) {
        if (fragment == null || flag)
            fragment = new PersonalFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal, null);
        Init(view);
        return view;
    }

    private void Init(View view) {
        //登录按钮
        Button loginBtn = (Button) view.findViewById(R.id.login_button);
        loginBtn.setOnClickListener(this);
        //注销按钮
        Button loginOutBtn = (Button) view.findViewById(R.id.login_out_button);
        loginOutBtn.setOnClickListener(this);
        //头像，积分以及连续登陆ViewGroup
        ViewGroup infoV = (ViewGroup) view.findViewById(R.id.personal_info_layout);
        //头像
        ImageView pIcon = (ImageView) view.findViewById(R.id.icon_personal_image_view);
        pIcon.setOnClickListener(this);
        //积分
        TextView centTextView = (TextView) view.findViewById(R.id.cent_personal_text_view);
        centTextView.setOnClickListener(this);
        //连续登陆
        TextView loginDaysTextView = (TextView) view.findViewById(R.id.login_days_personal_text_view);
        loginDaysTextView.setOnClickListener(this);
        //个人资料和错题集ViewGroup
        ViewGroup infoMenuV = (ViewGroup) view.findViewById(R.id.personal_info_menu_layout);
        //个人资料
        ViewGroup pInfo = (ViewGroup) view.findViewById(R.id.p_info_layout);
        pInfo.setOnClickListener(this);
        //错题集
        ViewGroup mBook = (ViewGroup) view.findViewById(R.id.m_book_layout);
        mBook.setOnClickListener(this);
        //设置
        ViewGroup settingV = (ViewGroup) view.findViewById(R.id.setting_layout);
        settingV.setOnClickListener(this);
        //联系我们
        ViewGroup contactV = (ViewGroup) view.findViewById(R.id.contact_layout);
        contactV.setOnClickListener(this);
        if (ConfigUtils.isLogin) {
            loginBtn.setVisibility(View.GONE);
            loginOutBtn.setVisibility(View.VISIBLE);
            infoV.setVisibility(View.VISIBLE);
            infoMenuV.setVisibility(View.VISIBLE);
        } else {
            loginBtn.setVisibility(View.VISIBLE);
            loginOutBtn.setVisibility(View.GONE);
            infoV.setVisibility(View.GONE);
            infoMenuV.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.login_button:{
                intent = new Intent(ContextUtils.getInstance(), LoginActivity.class);
                getActivity().startActivityForResult(intent, ConfigUtils.LOGIN_REQUEST_CODE);
                break;
            }
            case R.id.login_out_button:{
                break;
            }
            case R.id.icon_personal_image_view:{
                intent = new Intent(ContextUtils.getInstance(), CommonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", ConfigUtils.PERSONAL_ICON);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
            case R.id.cent_personal_text_view:{
                intent = new Intent(ContextUtils.getInstance(), CommonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", ConfigUtils.PERSONAL_CENT);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
            case R.id.login_days_personal_text_view:{
                intent = new Intent(ContextUtils.getInstance(), CommonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", ConfigUtils.PERSONAL_LOGIN_DAYS);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
            case R.id.p_info_layout:{
                intent = new Intent(ContextUtils.getInstance(), CommonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", ConfigUtils.PERSONAL_INFO);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
            case R.id.m_book_layout:{
                intent = new Intent(ContextUtils.getInstance(), CommonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", ConfigUtils.PERSONAL_MISTAKE_BOOK);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
            case R.id.setting_layout: {
                intent = new Intent(ContextUtils.getInstance(), CommonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", ConfigUtils.PERSONAL_SETTING);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
            case R.id.contact_layout: {
                intent = new Intent(ContextUtils.getInstance(), CommonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", ConfigUtils.PERSONAL_CONTACT);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
        }
    }
}
