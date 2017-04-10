package com.thesethree.nurse;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.thesethree.nurse.UI.CourseFragment;
import com.thesethree.nurse.UI.HomeFragment;
import com.thesethree.nurse.UI.PersonalFragment;
import com.thesethree.nurse.UI.TestFragment;
import com.thesethree.nurse.Utils.ConfigUtils;

public class MainActivity extends BaseActivity {

    private FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle(R.string.title_home);
                    setContent(HomeFragment.getInstance());
                    return true;
                case R.id.navigation_course:
                    setTitle(R.string.title_course);
                    setContent(CourseFragment.getInstance());
                    return true;
                case R.id.navigation_test:
                    setTitle(R.string.title_test);
                    setContent(TestFragment.getInstance());
                    return true;
                case R.id.navigation_personal:
                    setTitle(R.string.title_personal);
                    setContent(PersonalFragment.getInstance());
                    return true;
            }
            return false;
        }

    };


    private void setContent(Fragment fragment) {
        if (fragmentManager == null)
            fragmentManager = getFragmentManager();
        if (fragment == null)
            fragment = HomeFragment.getInstance();
        if (fragmentManager != null && fragment != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content, fragment);
            transaction.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.title_home);
        setContentView(R.layout.activity_main);
        setContent(null);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case ConfigUtils.LOGIN_REQUEST_CODE:

                break;
        }
    }
}
