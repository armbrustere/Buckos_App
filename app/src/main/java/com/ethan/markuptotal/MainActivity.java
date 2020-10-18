package com.ethan.markuptotal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {|
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        ppEditText = (EditText) findViewById(R.id.partPriceEditText);
        markupTextView = (TextView) findViewById(R.id.markupTextView);
        ttView = (TextView) findViewById(R.id.totalTextView);
        isSubzeroSwitch = (Switch) findViewById(R.id.subzeroSwitch);

        ppEditText.setOnEditorActionListener((TextView.OnEditorActionListener) this);
        savedVals = this.getSharedPreferences("SavedVals", MODE_PRIVATE);
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calcMarkup();
        }
        return false;
    }

    public void calcMarkup() {
        //added Try catch block here- Ethan Armbruster
        try {
            // get the price amount
            partPriceString = ppEditText.getText().toString();
            double partAmount = Double.parseDouble(partPriceString);
            double totalAmount = 0;

            // display the new markup with formatting
            NumberFormat currency = NumberFormat.getCurrencyInstance();


            // calculate markup for notSubzero
            while (!isSubzeroSwitch.isChecked()) {
                if (partAmount >= .01 && partAmount <= 3.00) {
                    String newTotW1 = Double.toString(totalAmount = partAmount * 3);
                    ttView.setText(currency.format(newTotW1));

                }
                if (partAmount >= 3.01 && partAmount <= 25.00) {
                    String newTotW2 = Double.toString(totalAmount = partAmount * 2);
                    ttView.setText(currency.format(newTotW2));
                }

                if (partAmount >= 25.01 && partAmount <= 60.00) {
                    String newTotW3 = Double.toString(totalAmount = partAmount * 1.85);
                    ttView.setText(currency.format(newTotW3));
                }

                if (partAmount >= 60.01 && partAmount <= 100.00) {
                    String newTotW4 = Double.toString(totalAmount = partAmount * 1.75);
                    ttView.setText(currency.format(newTotW4));
                }
                if (partAmount >= 100.01) {
                    String newTotW5 = Double.toString(totalAmount = partAmount * 1.65);
                    ttView.setText(currency.format(newTotW5));
                }
                String markupAmount = Double.toString(totalAmount - partAmount);
                markupTextView.setText(currency.format(markupAmount));
            }

            // calculate markup for Subzero
            while (!isSubzeroSwitch.isChecked()) {
                if (partAmount >= .01 && partAmount <= 3.00) {
                    String newTotS1 = Double.toString(totalAmount = partAmount * 3.1);
                    ttView.setText(currency.format(newTotS1));

                }
                if (partAmount >= 3.01 && partAmount <= 25.00) {
                    String newTotS2 = Double.toString(totalAmount = partAmount * 2.1);
                    ttView.setText(currency.format(newTotS2));
                }

                if (partAmount >= 25.01 && partAmount <= 60.00) {
                    String newTotS3 = Double.toString(totalAmount = partAmount * 1.95);
                    ttView.setText(currency.format(newTotS3));
                }

                if (partAmount >= 60.01 && partAmount <= 100.00) {
                    String newTotS4 = Double.toString(totalAmount = partAmount * 1.85);
                    ttView.setText(currency.format(newTotS4));
                }
                if (partAmount >= 100.01) {
                    String newTotS5 = Double.toString(totalAmount = partAmount * 1.75);
                    ttView.setText(currency.format(newTotS5));
                }
                String markupAmount = Double.toString(totalAmount - partAmount);
                markupTextView.setText(currency.format(markupAmount));
            }

        } catch (NumberFormatException e) {
            ppEditText.setText("0.00");
        }
    }

}