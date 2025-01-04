package com.example.morsecodetranslator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.morsecodetranslator.Adapters.ViewPagerAdapter;
import com.example.morsecodetranslator.Fragments.AlphabetsFragment;
import com.example.morsecodetranslator.Fragments.NumberFragment;
import com.example.morsecodetranslator.Fragments.SymbolsFragment;
import com.google.android.material.tabs.TabLayout;

public class DictionaryActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    String ROOT_FRAGMENT_TAG = "root_fragment";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view);

        tabLayout.setupWithViewPager(viewPager);

        FragmentManager fm = getSupportFragmentManager();
        viewPagerAdapter = new ViewPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPagerAdapter.addFragment(new NumberFragment(),"Numbers");
        viewPagerAdapter.addFragment(new AlphabetsFragment(),"Alphabets");
        viewPagerAdapter.addFragment(new SymbolsFragment(),"Symbols");

        viewPager.setAdapter(viewPagerAdapter);
    }
}