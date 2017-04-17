package com.example.apple.moviedemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apple.moviedemo.R;
import com.example.apple.moviedemo.fragment.DiscoveryFragment;
import com.example.apple.moviedemo.fragment.HomeFragment;
import com.example.apple.moviedemo.fragment.MineFragment;
import com.example.apple.moviedemo.fragment.MovieFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvHome;
    private TextView mTvMovie;
    private TextView mTvDiscovery;
    private TextView mTvMore;
    private FragmentManager fragmentManager;
    private HomeFragment mHomeFragment;
    private Fragment mMovieFragment;
    private Fragment mDiscoveryFragment;
    private Fragment mMineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
        fragmentManager = getSupportFragmentManager();
        // 第一次启动时选中第0个tab
        select(1);
    }

    private void setListener() {
        mTvHome.setOnClickListener(this);
        mTvMovie.setOnClickListener(this);
        mTvDiscovery.setOnClickListener(this);
        mTvMore.setOnClickListener(this);
    }

    private void initView() {
        mTvHome = (TextView) findViewById(R.id.tv_home);
        mTvMovie = (TextView) findViewById(R.id.tv_movie);
        mTvDiscovery = (TextView) findViewById(R.id.tv_discovery);
        mTvMore = (TextView) findViewById(R.id.tv_more);
//        hahaaaaaad
//        hahaaaaaad
//        hahaaaaaad
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_home:
                select(1);
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();

                break;

            case R.id.tv_movie:
                select(2);
                Toast.makeText(this, "222", Toast.LENGTH_SHORT).show();

                break;

            case R.id.tv_discovery:
                select(3);
                Toast.makeText(this, "333", Toast.LENGTH_SHORT).show();

                break;

            case R.id.tv_more:
                select(4);
                Toast.makeText(this, "444", Toast.LENGTH_SHORT).show();

                break;

        }
    }


    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index 每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void select(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 1:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                mTvHome.setTextColor(Color.WHITE);

                if (mHomeFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.content, mHomeFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mHomeFragment);
                }
                break;
            case 2:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                mTvMovie.setTextColor(Color.WHITE);
                if (mMovieFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mMovieFragment = new MovieFragment();
                    transaction.add(R.id.content, mMovieFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mMovieFragment);
                }
                break;
            case 3:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                // 当点击了消息tab时，改变控件的图片和文字颜色
                mTvDiscovery.setTextColor(Color.WHITE);

                if (mDiscoveryFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mDiscoveryFragment = new DiscoveryFragment();
                    transaction.add(R.id.content, mDiscoveryFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mDiscoveryFragment);
                }
                break;
            case 4:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                mTvMore.setTextColor(Color.WHITE);
                if (mMineFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mMineFragment = new MineFragment();
                    transaction.add(R.id.content, mMineFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mMineFragment);
                }
                break;

        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        mTvHome.setTextColor(Color.BLACK);
        mTvMovie.setTextColor(Color.BLACK);
        mTvDiscovery.setTextColor(Color.BLACK);
        mTvMore.setTextColor(Color.BLACK);




    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mMovieFragment != null) {
            transaction.hide(mMovieFragment);
        }
        if (mDiscoveryFragment != null) {
            transaction.hide(mDiscoveryFragment);
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment);
        }
    }
}
