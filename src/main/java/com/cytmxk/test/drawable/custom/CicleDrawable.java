package com.cytmxk.test.drawable.custom;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Created by chenyang on 16/8/13.
 */
public class CicleDrawable extends Drawable {

    private Paint paint;

    public CicleDrawable() {
        this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFF00FF00);
    }

    @Override
    public void draw(Canvas canvas) {
        final Rect r = getBounds();
        canvas.drawCircle(r.exactCenterX(), r.exactCenterY(), Math.min(r.exactCenterX(), r.exactCenterY()), paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        // not sure, so be safe
        return PixelFormat.TRANSLUCENT;
    }
}
