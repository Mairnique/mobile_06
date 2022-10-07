package com.chumaribelle.mobile_06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager2 v;
    RecyclerView.Adapter fragmentAdapter;
    int NUM_ITEMS = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // assign the instance of View Pager 2
        v = findViewById(R.id.container);
        // create an adapter for View Pager 2
        fragmentAdapter = new fragmentStateAdapter(this);
        // set the adapter for the View Pager
        v.setAdapter(fragmentAdapter);

    }

    private class fragmentStateAdapter extends FragmentStateAdapter {
        public fragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return MainFragment.newInstance(v, position);
        }

        @Override
        // how many fragments you can have, how many swipes
        public int getItemCount() {
            return NUM_ITEMS;
        }
    }

}