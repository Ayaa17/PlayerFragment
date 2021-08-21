package com.example.player_test06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private String TAG= getClass().getSimpleName();
    private ViewPager2 mainviewpage;
    private Fragment vediofragment,foofragment;
    private TabLayout tabLayout;
    TabLayoutMediator tabLayoutMediator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vediofragment = new VedioFragment();
        foofragment = new FooFragment();
        tabLayout= findViewById(R.id.tablayout);
        mainviewpage = findViewById(R.id.mainViewPage);

        mainviewpage.setAdapter(new FragmentStateAdapter(MainActivity.this) {
            @Override
            public int getItemCount() {
                return 3;
            }

            @NonNull
            @org.jetbrains.annotations.NotNull
            @Override
            public Fragment createFragment(int position) {

                switch (position) {

                    case 1:
                        return new VedioFragment();

                    default:
                        return new FooFragment();
                }

            }
        });
//        mainviewpage
        mainviewpage.setCurrentItem(1,false);
        mainviewpage.setOffscreenPageLimit(3);
        new TabLayoutMediator(tabLayout, mainviewpage, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @org.jetbrains.annotations.NotNull TabLayout.Tab tab, int position) {
                if(position==1){
                    tab.setText("vedio");
                }else {
                    tab.setText("foo");
                }
            }
        }).attach();

//        tabLayoutMediator.attach();
    }

}