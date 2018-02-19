package com.a081995gmail.ivany4.android.classwork2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class CustomView extends View {
    private float radius;
    private Paint paint;
    private float cx;
    private float cy;
    private RectF rect;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w / 2;
        cy = h / 2;
        radius = w > h ? cy/4 : cx/4;
        rect = new RectF();

        float wRect = w * 0.9f;
        float hRect = h * 0.2f;
        rect.left = (w - wRect) / 2;
        rect.top = (h - hRect) / 2;
        rect.right = w - rect.left;
        rect.bottom = h - rect.top;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                break;
            }
            case MotionEvent.ACTION_UP:{
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                cx = event.getX();
                cy = event.getY();
                invalidate();
                return false;
            }
        }



        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        canvas.drawCircle(getWidth() , getHeight() , radius, paint);
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect,paint);

        //  canvas.drawLine(0, 0, getWidth(), getHeight(), paint);
//invalidate(); перерисовывать экран
       // canvas.drawRect(rect, paint);
        /*canvas.save();
         canvas.rotate(90, cx, cy);
        canvas.restore(); dz*/
    }
}