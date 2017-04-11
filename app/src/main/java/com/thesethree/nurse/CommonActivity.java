package com.thesethree.nurse;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.thesethree.nurse.Utils.ConfigUtils;

public class CommonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        setupActionBar();

        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        switch (name) {
            case ConfigUtils.PERSONAL_CONTACT:
                setTitle(R.string.title_contact);
                break;
            case ConfigUtils.PERSONAL_SETTING:
                setTitle(R.string.title_setting);
                break;
            case ConfigUtils.PERSONAL_MISTAKE_BOOK:
                setTitle(R.string.title_mistake_book);
                break;
            case ConfigUtils.PERSONAL_INFO:
                setTitle(R.string.title_personal_info);
                break;
            case ConfigUtils.PERSONAL_ICON:
                setTitle(R.string.title_personal_icon);
                break;
            case ConfigUtils.PERSONAL_CENT:
                setTitle(R.string.title_personal_cent);
                break;
            case ConfigUtils.PERSONAL_LOGIN_DAYS:
                setTitle(R.string.title_personal_login_days);
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
                actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            setResult(RESULT_CANCELED);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
