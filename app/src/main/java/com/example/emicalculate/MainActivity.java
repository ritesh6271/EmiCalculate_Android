package com.example.emicalculate;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private EditText mLoanAmount, mInterestRate, mLoanPeriod;
    private TextView mMontlyPaymentResult, mTotalPaymentsResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoanAmount=(EditText) findViewById(R.id.loan_amount);
        mInterestRate=(EditText) findViewById(R.id.interest_rate);
        mLoanPeriod=(EditText) findViewById(R.id.loan_period);
        mMontlyPaymentResult=(TextView) findViewById(R.id.monthly_payment_result);
        mTotalPaymentsResult=(TextView) findViewById(R.id.total_payment_result);



    }

    public void showLoanPayments(View clickedButton){
        double loanAmount = Integer.parseInt(mLoanAmount.getText().toString());
        double interestRate = (Integer.parseInt(mInterestRate.getText().toString()));
        double loanPeriod = Integer.parseInt(mLoanPeriod.getText().toString());
        double r = interestRate/1200;
        double r1= Math.pow(r+1,loanPeriod);

        double monthlyPayment = (double) ((r+(r/(r1-1))) * loanAmount);
        double totalPayment = monthlyPayment * loanPeriod;

        mMontlyPaymentResult.setText(new DecimalFormat("##.##").format(monthlyPayment));
        mTotalPaymentsResult.setText(new DecimalFormat("##.##").format(totalPayment));
    }
}
