package com.learn.bgapulldowme.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.learn.bgapulldowme.MyApp;
import com.learn.bgapulldowme.R;
import com.learn.bgapulldowme.utils.ToastUtil;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Administrator on 2016/12/21 0021.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    protected String TAG;
    protected MyApp mApp;

    private SweetAlertDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
        mApp = MyApp.getInstance();
        initView(savedInstanceState);
        setListener();
    }


    /**
     * 查找View
     *
     * @param id
     * @param <VT>
     * @return
     */
    protected <VT extends View> VT getViewById(@IdRes int id)
    {
        return (VT) findViewById(id);
    }

    /**
     * 初始化布局以及View控件
     *
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 给View控件添加事件监听器
     */
    protected abstract void setListener();

    /**
     * 处理业务逻辑状态恢复等操作
     *
     * @param savedInstanceState
     */
    protected abstract void processLogic(Bundle savedInstanceState);

    protected void showToast(String text)
    {
        ToastUtil.show(text);
    }

    public void showLoadingDialog()
    {
        if (mLoadingDialog == null) {
            mLoadingDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            mLoadingDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
            mLoadingDialog.setCancelable(false);
            mLoadingDialog.setTitleText("数据加载中...");
        }
        mLoadingDialog.show();
    }

    public void dismissLoadingDialog()
    {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void onClick(View view) {

    }
}
