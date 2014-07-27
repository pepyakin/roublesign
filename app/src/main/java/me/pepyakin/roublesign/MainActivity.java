package me.pepyakin.roublesign;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText priceInput = (EditText) findViewById(R.id.main_price_input);

        Typeface roubleTypeface = Typeface.createFromAsset(getAssets(), "fonts/rouble2.ttf");

        String priceHint = getString(R.string.main_price_hint);
        SpannableStringBuilder ssb = new SpannableStringBuilder(priceHint);
        for (int i = 0; i < ssb.length(); i++) {
            if (ssb.charAt(i) == '\u20BD') {
                TypefaceSpan2 roubleTypefaceSpan = new TypefaceSpan2(roubleTypeface);
                ssb.setSpan(roubleTypefaceSpan, i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        priceInput.setHint(ssb);
    }
}
