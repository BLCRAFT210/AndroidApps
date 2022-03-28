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
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        canvas.drawCircle(540,1140,300, p);
        p.setColor(Color.WHITE);
        canvas.drawCircle(540,1140,295, p);
        p.setColor(Color.BLACK);
        canvas.drawCircle(440,1050,30, p);
        canvas.drawCircle(640,1050,30, p);
        RectF rectF = new RectF(420,1125,660,1325);
        canvas.drawArc(rectF,0,180,true,p);
    }
}
