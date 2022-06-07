package com.example.p3laibrianfinalproject;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class VolleyFragment extends Fragment {
    ViewPager2 mViewPager2;
    public static Fragment newInstance(ViewPager2 mViewPager2) {
        VolleyFragment fragment = new VolleyFragment();
        fragment.mViewPager2 = mViewPager2;
        return fragment;
    }
}
