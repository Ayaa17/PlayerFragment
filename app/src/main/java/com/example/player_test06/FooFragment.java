package com.example.player_test06;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;


public class FooFragment extends Fragment {

    Handler handler;
//    Bundle bundle=new Bundle();

    int ii;
    String test;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ii=bundle.getInt("Item");
//        Log.d("Bundle", "onViewCreated: "+ii);
//        Bundle bundle = getArguments();
//        Bundle bundle =getArguments();
//        test = bundle.getString("test");
//        Log.i("test", test);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_foo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        handler=new Handler()；
//       ii=bundle.getInt("location");
//        Log.d("Bundle", "onViewCreated: "+ii);
    }

    @Override
    public void onResume() {
        super.onResume();
//        ii=bundle.getInt("Item");
//        Log.d("Bundle", "onViewCreated: "+ii);

    }
}