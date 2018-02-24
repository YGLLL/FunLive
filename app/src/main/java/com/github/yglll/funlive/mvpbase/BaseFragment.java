package com.github.yglll.funlive.mvpbase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/19   23:24
 **/
public abstract class BaseFragment<M extends BaseModel,P extends BasePresenter> extends Fragment {

    //定义Presenter
    protected P mPresenter;
    protected Unbinder unbinder;

    //在初始化时绑定MVP
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        View view =inflater.inflate(getLayoutId(),viewGroup,false);
        //注解绑定
        unbinder = ButterKnife.bind(this,view);
        bindMVP();
        onInitView(bundle);
        return view;
    }

    //在销毁时解除绑定
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (mPresenter != null) {
            ContractProxy.getInstance().unbindView(getViewImp(), mPresenter);
            ContractProxy.getInstance().unbindModel(getModelClazz(), mPresenter);
            mPresenter = null;
        }
    }

    //获取布局资源文件
    protected abstract int getLayoutId();

    protected abstract void onInitView(Bundle bundle);

    private void bindMVP() {
        if (getPresenterClazz() != null) {
            mPresenter = getPresenterImpl();
            mPresenter.mContext = getActivity();
            bindVM();//Presenter绑定VM
        }
    }
    private  void bindVM() {
        if(mPresenter!=null&&!mPresenter.isViewBind()&&getModelClazz()!=null&&getViewImp()!=null) {
            ContractProxy.getInstance().bindModel(getModelClazz(),mPresenter);
            ContractProxy.getInstance().bindView(getViewImp(),mPresenter);
            mPresenter.mContext=getActivity();
        }
    }

    //   获取抽取View对象
    protected   abstract BaseView getViewImp();
    //    获得抽取接口Presenter对象
    protected Class getPresenterClazz() {
        return (Class<P>) ContractProxy.getPresnterClazz(getClass(), 1);
    }
    //    获得抽取接口Model对象
    protected   Class getModelClazz()  {
        return (Class<M>)ContractProxy.getModelClazz(getClass(), 0);
    }
    //获得Presenter实例
    private <T> T getPresenterImpl() {
        return ContractProxy.getInstance().presenter(getPresenterClazz());
    }
}
