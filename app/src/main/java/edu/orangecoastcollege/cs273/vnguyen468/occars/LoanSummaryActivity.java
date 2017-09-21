package edu.orangecoastcollege.cs273.vnguyen468.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {

    private TextView loanReportTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        loanReportTextView = (TextView) findViewById(R.id.monthlyPaymentTextView);

        //Receive the intent (from PurchaseActivity)
        //Populate the textView with data.

        Intent intentFromPurchase = getIntent();
        String report = intentFromPurchase.getStringExtra("loanReport");

        //Fill your TextView with data from the report.
        loanReportTextView.setText(report.toString());
    }
}
