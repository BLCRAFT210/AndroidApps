package com.example.p3l07laibrianfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    View view;
    public static FragmentB newInstance(int x,String s)
    {
        FragmentB fragmentB = new FragmentB();
        Bundle args = new Bundle();
        args.putInt("MyAge", x);
        args.putString("MyName", s);
        fragmentB.setArguments(args);
        return fragmentB;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        int age = getArguments().getInt("MyAge", 1);
        String name = getArguments().getString("MyName", "Joe");
        TextView textview = view.findViewById(R.id.bTextView);
        textview.setText("Hey "+name);
        Button button = view.findViewById(R.id.bButton);
        button.setText("Press me"+age);
    }
}
