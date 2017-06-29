package com.example.yls.newsclient.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Fragment基类
 * Created by yls on 2017/6/27.
 */

public abstract class BaseFragment extends Fragment {

    protected  View mRoot;
    protected Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (mRoot == null){
            mRoot = LayoutInflater.from(mActivity).inflate(getLayoutRes(), container, false);
            initView();
           initListener();
           initData();
       }
        return mRoot;

    }

    /**  返回一个Fragment要显示的布局界面 */
    public abstract int getLayoutRes();

    /** 查找布局中的子控件 */
    public abstract void initView();

    /** 设置控件的监听器 */
    public abstract void initListener();

    /** 初始化数据 */
    public abstract void initData();

    private Toast mToast;

    public void showToast(String msg){
        if (mToast == null){
            mToast = Toast.makeText(mActivity, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
