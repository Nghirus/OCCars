package edu.orangecoastcollege.cs273.vnguyen468.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PurchaseActivity extends AppCompatActivity {
    //Connections to the View
    private EditText mPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearRadioButton;
    private RadioButton mFourYearRadioButton;
    private RadioButton mFiveYearRadioButton;

    //Connection to the Model.
    private CarLoan mCarLoan = new CarLoan();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        //use findViewByID to connect controller to each view.
        mPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        mThreeYearRadioButton = (RadioButton) findViewById(R.id.threeYearRadioButton);
        mFourYearRadioButton = (RadioButton) findViewById(R.id.fourYearRadioButton);
        mFiveYearRadioButton = (RadioButton) findViewById(R.id.fiveYearRadioButton);
    }

    private void collectCarLoanData()
    {
        mCarLoan.setPrice(Double.parseDouble(mPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));

        if (mThreeYearRadioButton.isChecked())
            mCarLoan.setLoanTerm(3);
        else if (mFourYearRadioButton.isChecked())
            mCarLoan.setLoanTerm(4);
        else if (mFiveYearRadioButton.isChecked())
            mCarLoan.setLoanTerm(5);
    }
    protected void reportSummary(View v)
    {
        collectCarLoanData();
        String report = "Monthly Payment: $" + mCarLoan.monthlyPayment() + "\n\n"
                + "Car Sticker Price: $" + mCarLoan.getPrice() + "\n"
                + "You will put down: $" + mCarLoan.getDownPayment() + "\n"
                + "Taxed Amt: $        " + mCarLoan.taxAmount() + "\n"
                + "Your Cost: $        " + mCarLoan.totalAmount() + "\n"
                + "Borrowed Amount:    " + mCarLoan.borrowedAmount() + "\n"
                + "Interest Amount:    " + mCarLoan.interestAmount() + "\n\n"
                + " Loan term is " + mCarLoan.getLoanTerm() + "years." + "\n\n";
        //Keep going for report.

        //Intents start new activities and can share data with them.
        Intent launchLoanSummary = new Intent(this,LoanSummaryActivity.class);
        // Put data into the Intent for Loan Summary to receive.
        launchLoanSummary.putExtra("loanReport",report);
        // Start the second activity
        startActivity(launchLoanSummary);
    }
}
