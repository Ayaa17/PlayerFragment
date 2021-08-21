package com.example.player_test06;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;


public class VedioFragment extends Fragment {


    private String TAG= getClass().getSimpleName();
    private Intent intent;
    private List<String> urllist4=Arrays.asList(
      "https://scontent.cdninstagram.com/v/t50.2886-16/10000000_657436595157033_4990681372013518322_n.mp4?_nc_ht=instagram.ftpe7-2.fna.fbcdn.net&_nc_cat=109&_nc_ohc=26ovXCYWDJwAX8b3aIY&edm=ADECaisBAAAA&ccb=7-4&oe=60CE90F0&oh=99fc220d4ffbe64d491fa6dc4b335e46&_nc_sid=ca78b6",
      "https://scontent.cdninstagram.com/v/t50.2886-16/10000000_657436595157033_4990681372013518322_n.mp4?_nc_ht=instagram.ftpe7-2.fna.fbcdn.net&_nc_cat=109&_nc_ohc=26ovXCYWDJwAX8b3aIY&edm=ADECaisBAAAA&ccb=7-4&oe=60CE90F0&oh=99fc220d4ffbe64d491fa6dc4b335e46&_nc_sid=ca78b6",
      "https://scontent.cdninstagram.com/v/t50.2886-16/10000000_109493031362467_3177034252561951889_n.mp4?_nc_ht=instagram.ftpe7-4.fna.fbcdn.net&_nc_cat=107&_nc_ohc=3de5UO3CrKYAX_fPTmu&edm=ADECaisBAAAA&ccb=7-4&oe=60CE676B&oh=53c5feebf1050cef956d36ebb501daee&_nc_sid=ca78b6"
    );
    private List<String> urllist5=Arrays.asList(
            "https://scontent.cdninstagram.com/v/t50.2886-16/10000000_109493031362467_3177034252561951889_n.mp4?_nc_ht=instagram.ftpe8-3.fna.fbcdn.net&_nc_cat=107&_nc_ohc=25IzKImpo-0AX_JZk0t&edm=ADECaisBAAAA&ccb=7-4&oe=60E773EB&oh=0253ebe9fddd22e6147921819affdd7f&_nc_sid=ca78b6",
            "https://scontent.cdninstagram.com/v/t50.2886-16/10000000_1202617760158844_4085457845145807265_n.mp4?_nc_ht=instagram.ftpe8-1.fna.fbcdn.net&_nc_cat=108&_nc_ohc=CiLhoS_GEhsAX-xQ-dU&tn=oxWJXg1hQ8f7Qnxc&edm=ADECaisBAAAA&ccb=7-4&oe=60E752A2&oh=d9fcd2e4f36c20b440cc84d9978e572b&_nc_sid=ca78b6",
            "https://instagram.ftpe8-4.fna.fbcdn.net/v/t50.16885-16/10000000_196616608869964_2801547546530195880_n.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLjcyMC5pZ3R2LmRlZmF1bHQiLCJxZV9ncm91cHMiOiJbXCJpZ193ZWJfZGVsaXZlcnlfdnRzX290ZlwiXSJ9&_nc_ht=instagram.ftpe8-4.fna.fbcdn.net&_nc_cat=104&_nc_ohc=kZ9aQys8e7MAX-ZXRY1&edm=ADECaisBAAAA&vs=17922655891549942_33666793&_nc_vs=HBksFQAYJEdJQ1dtQUJNN2lCZjBySUFBS2lwVEh5bUdPRW1idlZCQUFBRhUAAsgBABUAGCRHS2h0THdrTTd1RWdFaTRHQUQyelg5Tm91WTlDYnZWQkFBQUYVAgLIAQAoABgAGwGIB3VzZV9vaWwBMRUAACbsxtW66aPWPxUCKAJDMywXQGYhDlYEGJMYEmRhc2hfYmFzZWxpbmVfMV92MREAdewHAA%3D%3D&_nc_rid=3d553f1ef7&ccb=7-4&oe=60E7288A&oh=d1aee0c2b224c41507b4d662a14613df&_nc_sid=ca78b6"
            );
    private List<String> urllist6=Arrays.asList(
            "https://scontent.cdninstagram.com/v/t50.2886-16/10000000_109493031362467_3177034252561951889_n.mp4?_nc_ht=instagram.ftpe8-3.fna.fbcdn.net&_nc_cat=107&_nc_ohc=25IzKImpo-0AX8PfMVc&edm=ADECaisBAAAA&ccb=7-4&oe=60EA16EB&oh=8d4aac67cc471bce32d55401dae8aee0&_nc_sid=ca78b6",
            "https://scontent.cdninstagram.com/v/t50.2886-16/10000000_657436595157033_4990681372013518322_n.mp4?_nc_ht=instagram.ftpe8-1.fna.fbcdn.net&_nc_cat=109&_nc_ohc=2hvqt96SVBIAX-wW5mp&edm=ADECaisBAAAA&ccb=7-4&oe=60EA4070&oh=bf4b1ca47b60948933e57ad8e19c1647&_nc_sid=ca78b6",
            "https://scontent.cdninstagram.com/v/t50.2886-16/10000000_794504251204310_6329613576885973568_n.mp4?_nc_ht=instagram.ftpe8-4.fna.fbcdn.net&_nc_cat=102&_nc_ohc=j485olPB8awAX_ZEZTD&edm=ADECaisBAAAA&ccb=7-4&oe=60EA6C25&oh=c88160753814072e539a1aec31851811&_nc_sid=ca78b6",
            "https://scontent.cdninstagram.com/v/t50.2886-16/10000000_148651757275476_1267496535949283654_n.mp4?_nc_ht=instagram.ftpe8-2.fna.fbcdn.net&_nc_cat=100&_nc_ohc=96cvJ9eL9HwAX9bfuzw&edm=ADECaisBAAAA&ccb=7-4&oe=60EA6CD7&oh=067e4ac13d3babeec65fa9ba4c3af6ba&_nc_sid=ca78b6"


    );




    private ViewPager2 vedioviewpage;
    private TextView vedioText;
//    FooFragment fooFragment = new FooFragment();
//    Handler handler=new Handler();
//    Bundle bundle= new Bundle();
//    FooFragment fooFragment = new FooFragment();

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        vedioviewpage.findViewById(R.id.vedioViewPage);
        Log.d(TAG, "onCreate: "+TAG);
//        bundle.putString("test","test");
//        fooFragment.setArguments(bundle);
//        vedioText.findViewById(R.id.vedioText);
//        vedioText.setText("aaa");



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vedio, container, false);
//        vedioText =(TextView) view.findViewById(R.id.vedioText);
//        vedioText.setText("aaa");
//        Log.d("123123", "onCreateView22: "+ .get(1));
//        Log.d("123123", "onCreateView: "+urllist3.size());
        return view;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vedioviewpage=view.findViewById(R.id.vedioViewPage);

        vedioText= (TextView) view.findViewById(R.id.vedioText);
        vedioText.setText("aaa");



        vedioviewpage.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return urllist6.size();
            }

            @NonNull
            @NotNull
            @Override
            public Fragment createFragment(int position) {
                Log.d(TAG, "createFragment: "+position);
                return new PlayerFragment(urllist6.get(position),position);

            }

        });

        vedioviewpage.setOffscreenPageLimit(1);

    }
    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: ");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onViewCreated:CurrentItem: "+vedioviewpage.getCurrentItem());
//        bundle.clear();
//        bundle.putInt("Item", 3);
        Log.d(TAG, "onPause: ");

//        Log.d("TAG", "onViewCreated: "+vedioviewpage.getCurrentItem());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }
}