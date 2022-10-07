package com.chumaribelle.mobile_06;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment {
    ViewPager2 v;
    int position;
    public static Fragment newInstance(ViewPager2 v, int position) {
        MainFragment fragment = new MainFragment();
        fragment.v = v;
        fragment.position = position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // add to tabLayout
        TabLayout tabLayout = getActivity().findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, v,
                (tab, position) -> tab.setText("I am " + (position + 1))
        ).attach();
        // access the button
        Button mButton = view.findViewById(R.id.pressme);
        // set text to identify fragment position
        mButton.setText("Press " + position);
    }
}
