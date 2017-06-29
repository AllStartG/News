package com.example.yls.newsclient;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.example.yls.newsclient.fragment.FoundFragment;
import com.example.yls.newsclient.fragment.NewsFragment;
import com.example.yls.newsclient.fragment.ReadFragment;
import com.example.yls.newsclient.fragment.SettingFragment;
import com.example.yls.newsclient.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager viewPager;
    private RadioGroup rg_01;
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        rg_01 = (RadioGroup) findViewById(R.id.rg_01);
        initViewPager();
        initNavigationView();
        initToolbar();
        initDrawerLayout();
    }

    //设置左上角的图标
    private void initDrawerLayout() {
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();  //同步drawerLayout和toolbar的状态
    }

    //使用toolbar代替ActionBar，并设置相应属性
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar); //使用toolBar代替ActionBar

//        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("广交新闻");

        //显示标题拦左上角的返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setSubtitle(""); //这是子标题
//        toolbar.setTitleTextColor(Color.RED);
//        toolbar.setSubtitleTextColor(Color.YELLOW);

        //导航栏图标显示
//        toolbar.setNavigationIcon(R.drawable.home_tab_01_normal);

        //点击toolbar导航栏左上角的图标后，推出当前页面
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

    private void initNavigationView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //侧滑菜单点击监听
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //点击侧滑菜单item时，通过DrawerLayout关闭侧滑菜单
                showToast("" + item.getTitle());
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new VideoFragment());
        fragments.add(new ReadFragment());
        fragments.add(new FoundFragment());
        fragments.add(new SettingFragment());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }

    @Override
    public void initListener() {
        rg_01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override  //点击单选时，调用此方法
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_01:         //点击单选时，切换viewPager子界面
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_02:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_03:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb_04:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.rb_05:
                        viewPager.setCurrentItem(4);
                        break;
                }
            }
        });

        /**  当viewPager子界面发生了改变时，要选中并高亮不同的RadioButton选项卡 */
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){  //当viewPager子界面切换后，选中某个RadioButton
                    case 0:
                        rg_01.check(R.id.rb_01);   //切换到新闻RadioButton
                        break;
                    case 1:
                        rg_01.check(R.id.rb_02);   //切换到视频RadioButton
                        break;
                    case 2:
                        rg_01.check(R.id.rb_03);   //切换到阅读RadioButton
                        break;
                    case 3:
                        rg_01.check(R.id.rb_04);    //切换到发现RadioButton
                        break;
                    case 4:
                        rg_01.check(R.id.rb_05);    //切换到设置RadioButton
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.it_01){
            showToast("标题1");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
