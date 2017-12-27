package com.iuicity.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Arrays;

/**
 * Created by Shui on 2017/12/21.
 */

public class MineHeadView extends FrameLayout {

    private Paint mCirclePaint;
    private Resources mResources;
    private Path mPath;
    private Path mArcPath;
    private PathMeasure mPathMeasure;
    private float[] mPos;
    private float[] mTan;
    private Paint mWhitePaint;
    private float mRatio = 0.30f;
    private int mMeasuredWidth;
    private int mMeasuredHeight;
    private Paint mTransPaint;

    public MineHeadView(@NonNull Context context) {
        this(context, null);
    }

    public MineHeadView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MineHeadView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setWillNotDraw(false);
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(Color.parseColor("#3ca2f4" ));

        mWhitePaint = new Paint();
        mWhitePaint.setAntiAlias(true);
        mWhitePaint.setColor(Color.parseColor("#f6f9fa"));
        mWhitePaint.setStyle(Paint.Style.STROKE);
        mWhitePaint.setStrokeWidth(8);

        mTransPaint = new Paint();
        mTransPaint.setAntiAlias(true);
        mTransPaint.setColor(Color.TRANSPARENT);

        mResources = getResources();
        mPath = new Path();
        mArcPath = new Path();

        mPathMeasure = new PathMeasure();
        mPos = new float[2];
        mTan = new float[2];
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMeasuredWidth = getMeasuredWidth();
        mMeasuredHeight = getMeasuredHeight();
        mPath.reset();
        mPath.lineTo(0, mMeasuredHeight);
        mPath.quadTo(mMeasuredWidth / 2, mMeasuredHeight * mRatio, mMeasuredWidth, mMeasuredHeight);
        mPath.lineTo(mMeasuredWidth, 0);
        mPath.lineTo(0, 0);

        mArcPath.reset();
        mArcPath.moveTo(0, mMeasuredHeight);
        mArcPath.quadTo(mMeasuredWidth / 2, mMeasuredHeight * mRatio, mMeasuredWidth, mMeasuredHeight);

        mPathMeasure.setPath(mArcPath, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(mPath);

        canvas.drawColor(Color.parseColor("#2195f2" ));
        canvas.drawCircle(getDimension(R.dimen.x500), getDimension(R.dimen.x70), getDimension(R.dimen.x39), mCirclePaint);
        canvas.drawCircle(getDimension(R.dimen.x70), 0, getDimension(R.dimen.x148), mCirclePaint);
        canvas.drawCircle(getDimension(R.dimen.x214), getDimension(R.dimen.x257), getDimension(R.dimen.x70), mCirclePaint);
        //需要调整
        canvas.drawCircle(getDimension(R.dimen.x600), getDimension(R.dimen.x248), getDimension(R.dimen.x60), mCirclePaint);
        canvas.drawCircle(mMeasuredWidth, getDimension(R.dimen.x132), getDimension(R.dimen.x85), mCirclePaint);

        mPathMeasure.getPosTan(mPathMeasure.getLength() / 2, mPos, mTan);

        super.onDraw(canvas);

        canvas.restore();
        canvas.drawCircle(mPos[0], mPos[1], getDimension(R.dimen.x79), mWhitePaint);

        addView();

    }

    private float getDimension(int res) {
        return mResources.getDimension(res);
    }

    public void addView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.mipmap.ic_launcher);
        addView(imageView);

        FrameLayout.LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        layoutParams.width = (int) getDimension(R.dimen.x146);
        layoutParams.height = (int) getDimension(R.dimen.x146);

        imageView.setX(mPos[0] - layoutParams.width / 2);
        imageView.setY(mPos[1] - layoutParams.height / 2);

        imageView.setLayoutParams(layoutParams);
    }
}
