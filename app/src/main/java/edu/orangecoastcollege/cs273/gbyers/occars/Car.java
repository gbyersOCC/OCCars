package edu.orangecoastcollege.cs273.gbyers.occars;

/**
 * @author Grant Byers
 * 9/14/2016
 */
public class Car {
    private static final double TAX_RATE = 0.08;
    private static final double THREE_RATE = .0462;
    private static final double FOUR_RATE = .0416;
    private static final double FIVE_RATE = .0419;
    private double mDownPayment;
    private int mLoanTerm;
    private double mPrice;
    private double interest;

    public Car()
    {
        mDownPayment = 0;
        mLoanTerm = 0;
        mPrice = 0;
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

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double calculateBorrowedAmount()
    {
//is borrowed amount (loan amount minus down payment)
       return (mPrice-mDownPayment)+(mPrice*TAX_RATE);

    }
    public double calculateInterestAmount()
    {
        if(mLoanTerm == 3)
            interest= THREE_RATE;
        else if(mLoanTerm==4)
            interest=FOUR_RATE;
        else if(mLoanTerm == 5)
            interest=FIVE_RATE;
        else
            interest=0;

        double borrowed = (mPrice-mDownPayment)+(mPrice*TAX_RATE);
        return borrowed * interest;

    }
    public double calculateMonthlyPayment()
    {
        int months = mLoanTerm*12;

        return calculateInterestAmount()+calculateBorrowedAmount()/months;


    }
    public double calculateTaxAmount()
    {
       return mPrice*TAX_RATE;

    }
    public double calculateTotalCost()
    {
        double total= (mPrice-mDownPayment)+(mPrice*TAX_RATE);
        return total;
    }
}
