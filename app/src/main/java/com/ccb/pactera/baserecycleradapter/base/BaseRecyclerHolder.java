package com.ccb.pactera.baserecycleradapter.base;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ChenboCui on 2018/5/2.
 */

public class BaseRecyclerHolder extends RecyclerView.ViewHolder {
    private SparseArrayCompat<View> mViews;
    public BaseRecyclerHolder(View itemView) {
        super(itemView);
        mViews = new SparseArrayCompat<>();
    }
    public <V extends View> V getView(@IdRes int res){
        View v = mViews.get(res);
        if (v == null){
            v = itemView.findViewById(res);
            mViews.put(res,v);
        }
        return (V)v;
    }

    /**
     * 直接赋值textview
     * @param TvRes
     * @param text
     */
    public BaseRecyclerHolder setText(@IdRes int TvRes,CharSequence text){
        TextView textView = getView(TvRes);
        textView.setText(text);
        return this;
    }
//    AnimatorRes ：animator资源类型
//    AnimRes：anim资源类型
//    AnyRes：任意资源类型
//    ArrayRes：array资源类型
//    AttrRes：attr资源类型
//    BoolRes：boolean资源类型
//    ColorRes：color资源类型
//    DimenRes：dimen资源类型。
//    DrawableRes：drawable资源类型。
//    FractionRes：fraction资源类型
//    IdRes：id资源类型
//    IntegerRes：integer资源类型
//    InterpolatorRes：interpolator资源类型
//    LayoutRes：layout资源类型
//    MenuRes：menu资源类型
//    PluralsRes：plurals资源类型
//    RawRes：raw资源类型
//    StringRes：string资源类型
//    StyleableRes：styleable资源类型
//    StyleRes：style资源类型
//    TransitionRes：transition资源类型
//    XmlRes：xml资源类型

    public BaseRecyclerHolder setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    public BaseRecyclerHolder setImageDrawable(@IdRes int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    /**
     * 点击事件
     * @param viewId
     * @param listener
     * @return
     */
    public BaseRecyclerHolder setOnClickListener(@IdRes int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
    public BaseRecyclerHolder setOnClickListener(View view, View.OnClickListener listener) {
        view.setOnClickListener(listener);
        return this;
    }

    public BaseRecyclerHolder setGone(@IdRes int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public BaseRecyclerHolder setVisible(@IdRes int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
        return this;
    }

    /**
     * 需要什么，直接添加即可；
     */
}
