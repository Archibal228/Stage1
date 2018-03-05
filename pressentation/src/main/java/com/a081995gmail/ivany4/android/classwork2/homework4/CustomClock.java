package com.a081995gmail.ivany4.android.classwork2.homework4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;


public class CustomClock extends View {
    private Paint paint;
    private float radius;
    private RectF hours;
    private RectF minute;
    double angle;

    public CustomClock(Context context) {
        super(context);
        init();
    }

    public CustomClock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomClock(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomClock(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = w > h ? h / 4 : w / 4;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.LTGRAY);
        canvas.drawCircle(getWidth() / 2, getHeight() / 4, radius, paint);
        paint.setColor(Color.WHITE);
        canvas.drawPoint(getWidth() / 2, getHeight() / 4, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(radius / 5);
        for (int i = 1; i <= 12; i++) {
            canvas.rotate(30, getWidth() / 2, getHeight() / 4);
            canvas.drawLine(getWidth() / 2, getHeight() / 4 - radius, getWidth() / 2, (float) (getHeight() / 4 - 0.8 * radius), paint);
        }
        canvas.drawText("12", getWidth() / 2 - radius / 15, (float) (getHeight() / 4 - 0.85 * radius), paint);
        canvas.drawText("3", (float) (getWidth() / 2 + 0.85 * radius), getHeight() / 4 + radius / 15, paint);
        canvas.drawText("6", getWidth() / 2 - radius / 15, getHeight() / 4 + radius, paint);
        canvas.drawText("9", getWidth() / 2 - radius, getHeight() / 4 + radius / 15, paint);
        Calendar calendar = Calendar.getInstance();
        float hour = calendar.get(Calendar.HOUR_OF_DAY);
        hour = hour > 12 ? hour - 12 : hour;
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println(hour);
        System.out.println("aaaaaaaaaaaaaaaaa");
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.MINUTE)/60.f);
        drawHandLine(canvas, (hour + calendar.get(Calendar.MINUTE) / 60.f)/12); // draw hours
        drawHandLine(canvas, calendar.get(Calendar.MINUTE)/60.f); // draw minutes
       // drawHandLine(canvas, calendar.get(Calendar.SECOND/60));

    }

    private void drawHandLine(Canvas canvas, float part) {
        angle =Math.PI/2 - part * Math.PI*2;
        canvas.drawLine(getWidth()/2, getHeight()/4,(float) (getWidth()/2 +radius*Math.cos(angle)),(float)(getHeight()/4 -radius*Math.sin(angle)),paint);
//        double angle = Math.PI * moment / 30 - Math.PI / 2;
//        int handRadius = isHour ? mRadius - mHandTruncation - mHourHandTruncation : mRadius - mHandTruncation;
//        if (isSecond) mPaint.setColor(Color.YELLOW);
       // canvas.drawLine(mWidth / 2, mHeight / 2, (float) (mWidth / 2 + Math.cos(angle) * handRadius), (float) (mHeight / 2 + Math.sin(angle) * handRadius), mPaint);
    }
}


