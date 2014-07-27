package me.pepyakin.roublesign;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/**
 * Slightly modified version of {@link android.text.style.TypefaceSpan TypefaceSpan}
 * which accepts actual {@link android.graphics.Typeface Typeface} reference instead of
 * family name string.
 *
 * @author pepyakin
 * @see android.text.style.TypefaceSpan
 */
public class TypefaceSpan2 extends MetricAffectingSpan {
    private final Typeface mTypeface;

    public TypefaceSpan2(Typeface typeface) {
        mTypeface = typeface;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds, mTypeface);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint, mTypeface);
    }

    private static void apply(Paint paint, Typeface tf) {
        int oldStyle;

        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }

        int fake = oldStyle & ~tf.getStyle();

        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }

        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }

        paint.setTypeface(tf);
    }
}