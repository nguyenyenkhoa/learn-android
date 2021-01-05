package com.example.b3_nguyenthiyenkhoa_b1709343;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
public class VeCoBan extends View{
    private final Paint paint = new Paint();

    public VeCoBan(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int xcanvas = canvas.getWidth();
        int ycanvas = canvas.getHeight();

        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLUE);
        paint.setTextSize(60);
        canvas.drawText("Lập TRÌNH GIAO DIỆN MỨC THẤP", 60, 80, paint);

        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        String Wcanvas = Integer.toString(xcanvas);
        canvas.drawText("Chiều rộng màn hình:" + Wcanvas, 80, 160, paint);
        String Hcanvas = Integer.toString(ycanvas);
        canvas.drawText("Chiều cao màn hình:"+Hcanvas, 80, 240, paint);

        RectF rectF = new RectF(30, ycanvas/4-40, xcanvas/2-60, ycanvas/2+20);
        paint.setColor(Color.WHITE);
        canvas.drawOval(rectF, paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, -135, 90, true, paint);


        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(xcanvas/2+60, ycanvas/4+100, xcanvas/8, paint);


        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawLine(xcanvas/2+xcanvas/4, ycanvas/4-40, xcanvas-60, ycanvas/2-120, paint);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(20, ycanvas/4+350, canvas.getWidth()-20, canvas.getHeight()-20, paint);


        paint.setColor(Color.RED);
        canvas.rotate(-45, xcanvas/4, ycanvas/4+450);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
        canvas.drawText("Seahorse", xcanvas/4, 3*ycanvas/4+200, paint);
        canvas.rotate(45, xcanvas/2, ycanvas/4+450);


        Resources res = this.getResources();
        Bitmap bit = BitmapFactory.decodeResource(res, R.drawable.seahorse);
        float d = bit.getWidth();
        float xstar = xcanvas/8;
        float ystar = 3*ycanvas/4;
        RectF rectF2 = new RectF(xstar, ystar, xstar+d, ystar+d);

        canvas.drawBitmap(bit, null, rectF2, paint);
    }
}
