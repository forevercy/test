package com.cytmxk.test.scroll;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by chenyang on 16/6/26.
 */
public class DragViewGroup extends FrameLayout {

    private static final String TAG = DragViewGroup.class.getCanonicalName();

    private ViewDragHelper mViewDragHelper = null;
    private View mMenuView = null;
    private View mMainView = null;
    private int mMenuWidth;

    public DragViewGroup(Context context) {
        super(context);
        initView();
    }

    public DragViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mViewDragHelper = ViewDragHelper.create(this, callback);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMenuWidth = mMenuView.getMeasuredWidth();
        Log.d(TAG, "onSizeChanged mMenuWidth = " + mMenuWidth);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        //将触摸事件传递给ViewDragHelper,此操作必不可少
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        // 何时开始检测触摸事件
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            //如果当前触摸的child是mMainView时开始检测
            return mMainView == child;
        }

        // 触摸到View后回调
        @Override
        public void onViewCaptured(View capturedChild,
                                   int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);
        }

        // 当拖拽状态改变，比如idle，dragging
        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);
        }

        // 当位置改变的时候调用,常用与滑动时更改scale等
        @Override
        public void onViewPositionChanged(View changedView,
                                          int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);
        }

        // 处理水平滑动
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        // 处理垂直滑动
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        // 拖动结束后调用
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            Log.d(TAG, "onViewReleased mMainView.getLeft() = " + mMainView.getLeft() + ", mMenuWidth = " + mMenuWidth);
            //手指抬起后缓慢移动到指定位置
            if (mMainView.getLeft() < mMenuWidth) {
                //关闭菜单
                //相当于Scroller的startScroll方法
                mViewDragHelper.smoothSlideViewTo(mMainView, 0, 0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            } else {
                //打开菜单
                mViewDragHelper.smoothSlideViewTo(mMainView, mMenuWidth, 0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }
        }

    };

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
}
