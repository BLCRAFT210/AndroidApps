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
    boolean frowning = false;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        canvas.drawCircle(540,1140,300, p);
        if (frowning)
            p.setColor(Color.rgb(255,(int) (255*(180-rectF.bottom+rectF.top)/180),0));
        else
            p.setColor(Color.YELLOW);
        canvas.drawCircle(540,1140,295, p);
        p.setColor(Color.BLACK);
        canvas.drawCircle(440,1050,30, p);
        canvas.drawCircle(640,1050,30, p);

        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(15);

        if (rectF.bottom<rectF.top){
            frowning = true;
        }

        canvas.save();
        if (!frowning)
        {
            canvas.drawArc(rectF,0,180,false,p);
            rectF.bottom--;
            rectF.top++;
        }
        else
        {
            canvas.drawArc(rectF,180,180,false,p);
            if (rectF.bottom<1375)
                rectF.bottom+=2;
        }
        canvas.restore();
        invalidate();
    }
}
