package com.example.lenovo.sentence;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
        private TabLayout mTabLayout;
        private ViewPager mViewPager;
        private List<Fragment> mlist=new ArrayList<Fragment>();
        private  MyFragmentPagerAdapter myFragmentPagerAdapter;
        private  Context mContext;
        private String[] titles=new String[]{"首页","偶遇佳句","分类大全","我的句库"};
        private final int[] pngs=new int[]{R.drawable.icon_home,R.drawable.icon_good_sentence,R.drawable.icon_type,R.drawable.icon_mine};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mTabLayout=findViewById(R.id.tl_tabs);
        mViewPager=findViewById(R.id.vp_content);
        mlist.add(new HomeFragment());
        mlist.add(new GsFragment());
        mlist.add(new TyFragment());
        mlist.add(new MineFragment());
        for(int i=0;i<titles.length;i++){
            mTabLayout.addTab(mTabLayout.newTab());
        }
        mTabLayout.setupWithViewPager(mViewPager,false);
        myFragmentPagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),mlist);
        for(int j=0;j<pngs.length;j++){
            mTabLayout.getTabAt(j).setIcon(pngs[j]);
        }
        for(int i=0;i<titles.length;i++){
            mTabLayout.getTabAt(i).setText(titles[i]);
        }
    }


}
