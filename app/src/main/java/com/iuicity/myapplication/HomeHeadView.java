package com.iuicity.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import static com.iuicity.myapplication.Utils.dip2px;

/**
 * 首页头部背景
 * Created by Shui on 2017/12/18.
 */

public class HomeHeadView extends FrameLayout {

    private Bitmap mBitmapBg;
    private Rect mRect;
    private Paint mPaint;
    private Path mPath;
    private Bitmap mBitmapCar;
    private PathMeasure mPathMeasure;
    private float mValue;
    private ValueAnimator mAnimator;
    private float mLength;
    private float[] mPos = new float[2];
    private float[] mTan = new float[2];
    private Path mArcPath;
    private Context mContext;
    private float[] mLocation = new float[]{0.15f, 0.44f, 0.75f};
    private float mEnd = mLocation[0];//最终的落点
    private float mTotalDegrees = 30;
    private Matrix mMatrix;

    public HomeHeadView(@NonNull Context context) {
        this(context, null);
    }

    public HomeHeadView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeHeadView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        setWillNotDraw(false);

        mBitmapBg = BitmapFactory.decodeResource(getResources(), R.mipmap.head);
        mBitmapCar = BitmapFactory.decodeResource(getResources(), R.mipmap.car);
        mBitmapCar = scaleBitmap(dip2px(45, mContext), dip2px(30, mContext), mBitmapCar);
        mRect = new Rect(0, 0, 0, 0);
        mPaint = new Paint();

        mPath = new Path();//总的path
        mArcPath = new Path();//弧形path
        mPathMeasure = new PathMeasure();
        mAnimator = ValueAnimator.ofFloat();
        mAnimator.setDuration(1000);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mValue = (float) animation.getAnimatedValue();
                mEnd = mValue;
                invalidate();
            }
        });
        mValue = mEnd;

        mMatrix = new Matrix();
    }

    /**
     * 缩放比天猫
     *
     * @param bitmap
     * @return
     */
    private Bitmap scaleBitmap(int newWidth, int newHeight, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        // 设置想要的大小
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return bitmap;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mRect.right = getMeasuredWidth();
        mRect.bottom = getMeasuredHeight();
        mPath.reset();
        float y = (float) (0.77 * getHeight());
        mPath.lineTo(0, y);
        mPath.quadTo(getWidth() / 2, getHeight() + 100, getWidth(), y);
        mPath.lineTo(getWidth(), 0);
        mPath.lineTo(0, 0);
        mPath.close();

        mArcPath.reset();
        mArcPath.moveTo(0, y);
        mArcPath.quadTo(getWidth() / 2, getHeight() + 100, getWidth(), y);

        mPathMeasure.setPath(mArcPath, false);
    }

    @Override
    public void draw(Canvas canvas) {
        drawBackground(canvas);
        super.draw(canvas);
    }

    private void drawBackground(Canvas canvas) {
//        canvas.save();

//        canvas.clipPath(mPath);
        Log.d("HomeHeadView", "mRect:" + mRect.toString());
        canvas.drawBitmap(mBitmapBg, mRect, mRect, mPaint);

//        //绘制小车
//        mLength = mPathMeasure.getLength();
//        float progress = mLength * mValue;
//        mPathMeasure.getPosTan(progress, mPos, mTan);
//        canvas.translate(mPos[0] - dip2px(5, mContext), mPos[1] - dip2px(20, mContext));
//        mMatrix.reset();
//        mMatrix.postRotate(getOffsetDegrees());
//        canvas.drawBitmap(mBitmapCar, mMatrix, mPaint);
//
//        canvas.restore();
    }

    /**
     * 获取偏转角度
     *
     * @return
     */
    private float getOffsetDegrees() {
        return -mValue * mTotalDegrees;
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mBitmapBg != null && !mBitmapBg.isRecycled()) {
            mBitmapBg.recycle();
        }
        mRect = null;
        mPaint = null;
        mMatrix = null;
        super.onDetachedFromWindow();
    }

    public void checkPosition(int position) {
        mAnimator.cancel();
        mAnimator.setFloatValues(mEnd, mLocation[position]);
        mAnimator.start();
    }
}
