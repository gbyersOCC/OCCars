package edu.orangecoastcollege.cs273.gbyers.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoanSummeryActivity extends Activity {

   private TextView monthlyPaymentTextView;
    private TextView loanReportTextView;
    private Button returnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summery);
        monthlyPaymentTextView= (TextView) findViewById(R.id.monthlyPaymentTextView);
        loanReportTextView = (TextView) findViewById(R.id.loanReportTextView);
        returnButton = (Button) findViewById(R.id.returnButton);

        Intent fromIntent = getIntent();

        String monthlyPaymentText = fromIntent.getStringExtra("MonthlyPayment");
        String loanReportText = fromIntent.getStringExtra("LoanSummary");



        monthlyPaymentTextView.setText(monthlyPaymentText);
        loanReportTextView.setText(loanReportText);

    }
    public void returnToDataEntry(View v)
    {
        this.finish();
    }
}
