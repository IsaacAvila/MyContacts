package com.example.hobo.mycontacts;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.example.hobo.mycontacts.adapter.PageAdapter;
import com.example.hobo.mycontacts.fragment.FragmentRecyclerView;
import com.example.hobo.mycontacts.fragment.Profile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar myActionBar;
    private TabLayout tl1;
    private ViewPager vp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myActionBar = (Toolbar)   findViewById(R.id.myActionBar);
        tl1         = (TabLayout) findViewById(R.id.tl1);
        vp1         = (ViewPager) findViewById(R.id.vp1);

        setUpViewPager();

        if (myActionBar != null) {
            setSupportActionBar(myActionBar);
        }
    }

    private ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentRecyclerView());
        fragments.add(new Profile());
        return fragments;
    }

    private void setUpViewPager() {
        vp1.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tl1.setupWithViewPager(vp1);
        tl1.getTabAt(0).setIcon(R.mipmap.ic_contacts);
        tl1.getTabAt(1).setIcon(R.mipmap.ic_profile);
    }
}
