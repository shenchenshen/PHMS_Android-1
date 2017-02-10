package com.cse6324.phms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import fragment.LoginFragment;
import fragment.RegisterFragment;
import fragment.SecurityQuestionFragment;

public class LoginActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegisterFragment registerFragment;
    SecurityQuestionFragment securityQuestionFragment;

    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();
        securityQuestionFragment = new SecurityQuestionFragment();

        changeFragment(0);
    }

    public void changeFragment(int index){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if(currentFragment != null){
            ft.hide(currentFragment);
        }

        Fragment fragment = null;

        switch (index){
            case 0:
                fragment = loginFragment;
                break;
            case 1:
                fragment = registerFragment;
                break;
            case 2:
                fragment = securityQuestionFragment;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
