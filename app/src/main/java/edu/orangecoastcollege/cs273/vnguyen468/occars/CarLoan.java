package edu.orangecoastcollege.cs273.vnguyen468.occars;

/**
 * Created by vnguyen468 on 9/14/2017.
 */

public class CarLoan {

    private static final double STATE_TAX = 0.08;
    private double mPrice;
    private double mDownPayment;
    private int mLoanTerm;

    CarLoan() {
        mPrice = 0.0;
        mDownPayment = 0.0;
        mLoanTerm = 0;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double downPayment) {
        mDownPayment = downPayment;
    }

    public int getLoanTerm() {
        return mLoanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        mLoanTerm = loanTerm;
    }

    public double taxAmount() {
        return mPrice * STATE_TAX;
    }

    public double totalAmount() {
        return mPrice + taxAmount();
    }

    public double borrowedAmount() {
        return mPrice - mDownPayment;
    }

    public double interestAmount() {
        /*
            3 year APR = 4.62%
            4 year APR = 4.19%
            5 year APR = 4.16%
         */
        double interestRate;
        switch (mLoanTerm) {
            case 3:
                interestRate = 0.0462;
                break;
            case 4:
                interestRate = 0.0419;
                break;
            case 5:
                interestRate = 0.0416;
                break;
            default:
                //Should never be used
                interestRate = 100.0;
                break;

        }

        return borrowedAmount() * interestRate;
    }

    public double monthlyPayment()
    {
        int numberOfPayments = mLoanTerm * 12;
        return (borrowedAmount() + interestAmount()) / numberOfPayments;
    }
}

