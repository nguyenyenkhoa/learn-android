package com.example.b3_nguyenthiyenkhoa_b1709343;

import android.view.View;
import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;

public class TuongTac extends  View{
    public final Paint paint = new Paint();
    public final Canvas c = new Canvas();
    public Bitmap bitmap;

    public float x = 50;
    public float y = 50;
    public int duonngkinh;
    public String st = "Begin test touch";
    public TuongTac(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas c){
        super.onDraw(c);
        paint.setColor(Color.WHITE);
        c.drawPaint(paint);
        paint.setColor(Color.BLUE);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.network);

        c.drawBitmap(bitmap, x, y, paint);
        duonngkinh = bitmap.getWidth();
        paint.setTextSize(60);
        c.drawText(st, x, y, paint);
    }


    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX() - (duonngkinh/2);
                y = event.getY() - (duonngkinh/2);
                st = "ACTION DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX() - (duonngkinh/2);
                y = event.getY() - (duonngkinh/2);
                st = "ACTION MOVE";
                break;
            case MotionEvent.ACTION_UP:
                x = event.getX() - (duonngkinh/2);
                y = event.getY() - (duonngkinh/2);
                st = "ACTION UP";
                break;
        }
        invalidate();
        return true;
    }
}
