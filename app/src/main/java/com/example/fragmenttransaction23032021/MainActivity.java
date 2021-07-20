package com.example.fragmenttransaction23032021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

    }

    public void addAndroid(View view) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentTransaction.add(R.id.linearlayoutContainer,androidFragment ,"fragmentAndroid");
        fragmentTransaction.addToBackStack("stackandroid");
        fragmentTransaction.commit();
    }

    public void addIos(View view) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        IosFragment iosFragment = new IosFragment();
        fragmentTransaction.add(R.id.linearlayoutContainer,iosFragment,"fragmentIos");
        fragmentTransaction.addToBackStack("stackios");
        fragmentTransaction.commit();
    }

    public void replaceAndroid(View view) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentTransaction.replace(R.id.linearlayoutContainer,androidFragment,"fragmentAndroid");
        fragmentTransaction.addToBackStack("stackandroid");
        fragmentTransaction.commit();
    }

    public void replaceIos(View view) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        IosFragment iosFragment = new IosFragment();
        fragmentTransaction.replace(R.id.linearlayoutContainer,iosFragment,"fragmentIos");
        fragmentTransaction.addToBackStack("stackios");
        fragmentTransaction.commit();
    }

    public void removeAndroid(View view) {
        AndroidFragment androidFragment = (AndroidFragment) mFragmentManager.findFragmentByTag("fragmentAndroid");
        if (androidFragment != null){
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.remove(androidFragment);
            fragmentTransaction.commit();
        }
    }

    public void removeIos(View view) {
        IosFragment iosFragment = (IosFragment) mFragmentManager.findFragmentByTag("fragmentIos");
        if (iosFragment != null){
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.remove(iosFragment);
            fragmentTransaction.commit();
        }
    }

    public void popbackstack(View view) {
        mFragmentManager.popBackStack(2,FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void detach(View view) {
        AndroidFragment androidFragment = (AndroidFragment) mFragmentManager.findFragmentByTag("fragmentAndroid");
        if (androidFragment != null){
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.detach(androidFragment);
            fragmentTransaction.commit();
        }
    }

    public void attach(View view) {
        AndroidFragment androidFragment = (AndroidFragment) mFragmentManager.findFragmentByTag("fragmentAndroid");
        if (androidFragment != null){
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.attach(androidFragment);
            fragmentTransaction.commit();
        }
    }
}