package edu.orangecoastcollege.cs273.gbyers.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PurchaseActivity extends Activity {
    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioButton fiveYearRadioButton;
    private RadioButton fourYearRadioButton;
    private RadioButton threeYearRadioButton;

    private Car currentCar;
    private String monthlyPaymentText;
    private String loanSummeryText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        carPriceEditText= (EditText)findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
         fiveYearRadioButton = (RadioButton) findViewById(R.id.fiveYearRadioButton);
        fourYearRadioButton = (RadioButton) findViewById(R.id.fourYearRadioButton);
        threeYearRadioButton = (RadioButton) findViewById(R.id.threeYearRadioButton);

        currentCar=new Car();

    }
    //made method for attribute
    public void activateLoanReport(View view)
    {
        double price, downPayment;
        try{
            price = Double.parseDouble(carPriceEditText.getText().toString());
            downPayment = Double.parseDouble((downPaymentEditText.getText().toString()));
        }catch(NumberFormatException e){
            price=0.0;
            downPayment=0.0;
        }
        int loanTerm;

        if(fiveYearRadioButton.isChecked())
            loanTerm = 5;
        else if(fourYearRadioButton.isChecked())
            loanTerm=4;
        else
            loanTerm = 3;

        currentCar.setPrice(price);
        currentCar.setDownPayment(downPayment);
        currentCar.setLoanTerm(loanTerm);
        Intent loanSummeryIntent = new Intent(this,LoanSummeryActivity.class);
        loanSummeryIntent.putExtra("MonthlyPayment",monthlyPaymentText);
        loanSummeryIntent.putExtra("LoanSummary", loanSummeryText);

        constructLoanSummeryText();

        startActivity(loanSummeryIntent);

    }

    private void constructLoanSummeryText()
    {
        monthlyPaymentText = getString(R.string.report_line1)+currentCar.calculateMonthlyPayment();
        loanSummeryText = getString(R.string.report_line2)+currentCar.getPrice()+getString(R.string.report_line3)+currentCar.getDownPayment() +
                getString(R.string.report_line4)+currentCar.getLoanTerm()+ getString(R.string.report_line5)+currentCar.calculateTaxAmount()+
                getString(R.string.report_line6)+ currentCar.calculateTotalCost()+ getString(R.string.report_line7)+currentCar.calculateBorrowedAmount()+
                getString(R.string.report_line8)+ currentCar.calculateInterestAmount()+getString(R.string.report_line9)+getString(R.string.report_line10)+
                getString(R.string.report_line11)+getString(R.string.report_line12);
    }

}
