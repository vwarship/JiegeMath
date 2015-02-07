package com.zaoqibu.jiegemath.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ImageButton;

/**
 * Created by vwarship on 2015/1/28.
 */
public class ImageButtonWithText extends ImageButton {
    private String text = null;

    public ImageButtonWithText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (text == null)
            return;

        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/halflife2.ttf");

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTypeface(font);
        paint.setTextSize(px2dip(getContext(),120f));

        int centerX = getMeasuredWidth()/2;
        int centerY = getMeasuredHeight()/2;
        canvas.drawText(text, centerX-getTextWidth(paint)/2, centerY+getTextHeight(paint)/2, paint);
    }

    private float getTextWidth(Paint paint) {
        if (text == null)
            return 0.0f;

        return paint.measureText(text);
    }

    private float getTextHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (float)Math.ceil(Math.abs(fontMetrics.ascent)-fontMetrics.descent);
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
