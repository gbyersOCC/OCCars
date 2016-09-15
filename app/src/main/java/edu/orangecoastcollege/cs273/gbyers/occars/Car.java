package edu.orangecoastcollege.cs273.gbyers.occars;

/**
 * Created by grant on 9/14/2016.
 */
public class Car {
    private static final double TAXRATE = 0.01;
    private int mDownPayment;
    private int mLoanTerm;
    private int mPrice;
    double interest;
    public Car()
    {
        mDownPayment = 0;
        mLoanTerm = 0;
        mPrice = 0;
    }


    public int getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(int downPayment) {
        mDownPayment = downPayment;
    }

    public int getLoanTerm() {
        return mLoanTerm;
    }

    public void setLoanTerm(int loanTerm) {

        mLoanTerm = loanTerm;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        mPrice = price;
    }

    public void calculateBorrowedAmount()
    {
//is borrowed amount (loan amount minus down payment)
        // mPrice = mPrice - mDownPayment;


    }
    public void calculateInterestAmount()
    {
//I = P*R*T
        interest = mPrice* (.0308)*mLoanTerm;

    }
    public void calculateMonthlyPayment()
    {
        int months = mLoanTerm*12;

double monthlyAmount = (mPrice*(3.08/1200)*(1+3.08/1200))/((1+3.08/1200)-1);
    }
    public void calculateTaxAmount()
    {
        mPrice*=TAXRATE;
    }
    public void calculateTotalCost()
    {

    }
}
