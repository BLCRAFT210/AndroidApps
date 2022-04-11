package com.example.p3l08laibriandrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    RectF rectF = new RectF(420,1125,660,1325);
    Paint p = new Paint();
    int deg = 0 ;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        canvas.drawCircle(540,1140,300, p);
        p.setColor(Color.WHITE);
        canvas.drawCircle(540,1140,295, p);
        p.setColor(Color.BLACK);
        canvas.drawCircle(440,1050,30, p);
        canvas.drawCircle(640,1050,30, p);

        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(15);
        canvas.save();
        //canvas.rotate(deg++, rectF.centerX(),rectF.centerY());
        canvas.drawArc(rectF,deg++,180-deg,false,p);
        canvas.restore();
        invalidate();
    }
}
