package com.zxn.wym.fireworks.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

import com.zxn.wym.fireworks.constants.Ratio;

public class FireworkView extends AppCompatImageView {

    private float mWidth;
    private float mHeight;

    private FireworkDrawable mImageDrawable;
    private Drawable mBackgroundDrawable;
    private String TAG = FireworkView.class.getSimpleName();

    public FireworkView(Context context) {
        super(context);
        init(context);
    }

    public FireworkView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public FireworkView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mWidth = context.getResources().getDisplayMetrics().widthPixels;
        Ratio.SCREEN_WIDTH = mWidth;
        mHeight = context.getResources().getDisplayMetrics().heightPixels;
        setWillNotDraw(false);
        mImageDrawable = new FireworkDrawable(mWidth, mHeight);
        mBackgroundDrawable = new NightDrawable(mWidth, mHeight);
        setBackgroundDrawable(mBackgroundDrawable);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        setBackgroundDrawable(mBackgroundDrawable);
        setImageDrawable(mImageDrawable);
        Log.i(TAG, "onAttachedToWindow: ");
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(TAG, "onMeasure: ");
        if (mWidth > 0 && mHeight > 0) {
            Log.i(TAG, "setMeasuredDimension: ");
            setMeasuredDimension((int) mWidth, (int) (mHeight));
        }
    }


    public void showFirework() {
        mImageDrawable.showFirework();
    }

//    /**
//     * Interface used to allow the creator of a Firework to run some code when the
//     * Firework is dismissed.
//     */
//    interface OnDismissListener {
//        /**
//         * This method will be invoked when the Firework is dismissed.
//         *
//         * @param fireworkView the fireworkView that was dismissed will be passed into the
//         *                     method
//         */
//        void onDismiss(FireworkView fireworkView);
//    }
//    private OnDismissListener mOnDismissListener;
    public void setOnDismissListener(FireworkDrawable.OnDismissListener listener) {
        mImageDrawable.setOnDismissListener(listener);
    }
}
