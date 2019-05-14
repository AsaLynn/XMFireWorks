package com.zxn.wym.fireworks.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.zxn.wym.fireworks.constants.Ratio;

public class FireworkView extends AppCompatImageView {

    private float mWidth;
    private float mHeight;

    private Drawable mImageDrawable;
    private Drawable mBackgroundDrawable;

    public FireworkView(Context context) {
        super(context);
        init(context);
    }

    public FireworkView(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public FireworkView(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mWidth = context.getResources().getDisplayMetrics().widthPixels;
        Ratio.SCREEN_WIDTH = mWidth;
        mHeight = context.getResources().getDisplayMetrics().heightPixels;
        setWillNotDraw(false);
        mImageDrawable = new FireworkDrawable(mWidth,mHeight);
        mBackgroundDrawable = new NightDrawable(mWidth,mHeight);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBackgroundDrawable(mBackgroundDrawable);
        setImageDrawable(mImageDrawable);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(mWidth>0&&mHeight>0){
            setMeasuredDimension((int) mWidth, (int) (mHeight));
        }
    }



}
