package com.example.initfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    InitFragment initFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initViews();
        initFragment();
    }

    private void initViews() {

        findViewById(R.id.btn_first).setOnClickListener(v -> replaceFragment(new FirstFragment()));

        findViewById(R.id.btn_second).setOnClickListener(v -> replaceFragment(new SecondFragment()));
    }

    private void replaceFragment(Fragment fragment) {
        String backStackName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStackName, 0);

        if (!fragmentPopped) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fr_main, fragment);
            ft.addToBackStack(backStackName);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else super.onBackPressed();
    }

    private void initFragment() {

        initFragment = InitFragment.newInstance("Message has been send from activity,(initialized fragment)");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr_main, initFragment)
                .commit();
    }
}