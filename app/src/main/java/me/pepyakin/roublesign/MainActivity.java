package me.pepyakin.roublesign;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText priceInput = (EditText) findViewById(R.id.main_price_input);

        String priceHint = getString(R.string.main_price_hint);
        CharSequence spannedPriceHint = spanWithRoubleTypeface(priceHint);
        priceInput.setHint(spannedPriceHint);
    }

    private CharSequence spanWithRoubleTypeface(String priceHint) {
        final Typeface roubleSupportedTypeface =
                Typeface.createFromAsset(getAssets(), "fonts/rouble2.ttf");

        SpannableStringBuilder resultSpan = new SpannableStringBuilder(priceHint);
        for (int i = 0; i < resultSpan.length(); i++) {
            if (resultSpan.charAt(i) == '\u20BD') {
                TypefaceSpan2 roubleTypefaceSpan = new TypefaceSpan2(roubleSupportedTypeface);
                resultSpan.setSpan(roubleTypefaceSpan, i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return resultSpan;
    }
}
