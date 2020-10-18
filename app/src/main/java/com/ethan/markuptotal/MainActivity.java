package com.ethan.markuptotal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener, Switch.OnClickListener {

    private EditText ppEditText;
    private TextView part_price_label;
    private Switch isSubzeroSwitch;
    private TextView markupLabel;
    private TextView markupTextView;
    private TextView ttView;
    private String switch_on;
    private String switch_off;
    private SharedPreferences savedVals;
    private String partPriceString;
    private NumberFormat currency = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        ppEditText = (EditText) findViewById(R.id.partPriceEditText);
        markupTextView = (TextView) findViewById(R.id.markupTextView);
        ttView = (TextView) findViewById(R.id.totalTextView);
        isSubzeroSwitch = (Switch) findViewById(R.id.subzeroSwitch);

        ppEditText.setOnEditorActionListener(this);
        isSubzeroSwitch.setOnClickListener(this);
        savedVals = this.getSharedPreferences("SavedVals", MODE_PRIVATE);
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calcMarkup();
        }
        return false;
    }

    @Override
    public void onClick(View v) {
            calcMarkup();
    }
    public void calcMarkup() {

        // get the price amount
        partPriceString = ppEditText.getText().toString();
        double partAmount = Double.parseDouble(partPriceString);
        double totalAmount = 0;


        // calculate markup for notSubzero
        if (!isSubzeroSwitch.isActivated()) {
            if (partAmount >= .01 && partAmount <= 3.00) {
                totalAmount = partAmount * 3;
                ttView.setText(currency.format(totalAmount));

            }
            if (partAmount >= 3.01 && partAmount <= 25.00) {
                totalAmount = partAmount * 2;
                ttView.setText(currency.format(totalAmount));
            }

            if (partAmount >= 25.01 && partAmount <= 60.00) {
                totalAmount = partAmount * 1.85;
                ttView.setText(currency.format(totalAmount));
            }

            if (partAmount >= 60.01 && partAmount <= 100.00) {
                totalAmount = partAmount * 1.75;
                ttView.setText(currency.format(totalAmount));
            }
            if (partAmount >= 100.01) {
                totalAmount = partAmount * 1.65;
                ttView.setText(currency.format(totalAmount));
//

            }

            // calculate markup for Subzero
            if (isSubzeroSwitch.isActivated()) {
                if (partAmount >= .01 && partAmount <= 3.00) {
                    totalAmount = partAmount * 3.1;
                    ttView.setText(currency.format(totalAmount));

                }
                if (partAmount >= 3.01 && partAmount <= 25.00) {
                    totalAmount = partAmount * 2.1;
                    ttView.setText(currency.format(totalAmount));
                }

                if (partAmount >= 25.01 && partAmount <= 60.00) {
                    totalAmount = partAmount * 1.95;
                    ttView.setText(currency.format(totalAmount));
                }

                if (partAmount >= 60.01 && partAmount <= 100.00) {
                    totalAmount = partAmount * 1.85;
                    ttView.setText(currency.format(totalAmount));
                }
                if (partAmount >= 100.01) {
                    totalAmount = partAmount * 1.75;
                    ttView.setText(currency.format(totalAmount));
                }

            }
            Double markupAmount = totalAmount - partAmount;
            markupTextView.setText(currency.format(markupAmount));
        }
    }


}

