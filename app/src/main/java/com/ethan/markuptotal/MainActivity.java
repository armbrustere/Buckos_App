package com.ethan.markuptotal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText partPriceEditText;
    private TextView part_price_label;
    private TextView isSubzeroLabel;
    private TextView markupLabel;
    private String markupTextView;
    private String totalTextView;
    private String switch_on;
    private String switch_off;
    private SharedPreferences savedVals;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
//        partPriceEditText = (EditText) findViewById(R.id.subtotalEditText);
//        part_price_label = (TextView) findViewById(R.id.discountAmountTextView);
//        isSubzeroLabel = (TextView) findViewById(R.id.discountPercentTextView);
//        markupLabel = (TextView) findViewById(R.id.totalTextView);
//        totalTextView.setOnEditorActionListener(this);
//        savedVals = this.getSharedPreferences("SavedVals", MODE_PRIVATE);
    }
}