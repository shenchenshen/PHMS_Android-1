package com.cse6324.phms;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cse6324.fragment.DietFragment;
import com.cse6324.fragment.MedicineFragment;
import com.cse6324.fragment.Notefragment;
import com.cse6324.fragment.ProfileFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by Jarvis on 2017/2/10.
 */

public class MainActivity extends AppCompatActivity{
    DietFragment dietFragment;
    MedicineFragment medicineFragment;
    Notefragment notefragment;
    ProfileFragment profileFragment;

    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dietFragment = new DietFragment();
        medicineFragment = new MedicineFragment();
        notefragment = new Notefragment();
        profileFragment = new ProfileFragment();

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_medicine) {
                    changeFragment(0);
                }
                if (tabId == R.id.tab_diet) {
                    changeFragment(1);
                }
                if (tabId == R.id.tab_notes) {
                    changeFragment(2);
                }
                if (tabId == R.id.tab_profile) {
                    changeFragment(3);
                }
            }
        });

    }

    public void changeFragment(int index){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if(currentFragment != null){
            ft.hide(currentFragment);
        }

        Fragment fragment = null;

        switch (index){
            case 0:
                fragment = medicineFragment;
                break;
            case 1:
                fragment = dietFragment;
                break;
            case 2:
                fragment = notefragment;
                break;
            case 3:
                fragment = profileFragment;
                break;
        }

        if (!fragment.isAdded()) {
            ft.add(R.id.frame_layout, fragment, fragment.getClass().getName());
        } else {
            ft.show(fragment);
        }

        currentFragment = fragment;

        ft.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
