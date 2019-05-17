package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class Triangle{
    private double a,b,c;
    Triangle(double _a, double _b, double _c){a= _a;b= _b; c=_c;}

    double area(){
        double p =(a+b+c)/2.0;
        double w=(p-a)*(p-b)*(p-c)*p;

        return Math.sqrt(w);
    }
}
public class triangle extends AppCompatActivity {

    public final static String TRIANGLE_RESULT="Area of triangle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        ((Button) findViewById(R.id.triangleCalcButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a= Double.parseDouble(((EditText)findViewById(R.id.aEitText)).getText().toString());
                double b= Double.parseDouble(((EditText)findViewById(R.id.bEditText)).getText().toString());
                double c= Double.parseDouble(((EditText)findViewById(R.id.cEditText)).getText().toString());

                Triangle T= new Triangle(a,b,c);
                ((TextView)findViewById(R.id.triangleResultTextView)).setText(Double.toString(T.area()));
            }
        });

        ((Button)findViewById(R.id.backAndAddButton)).setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        String area_string=((TextView)findViewById(R.id.triangleResultTextView))
                                .getText().toString();

                            Intent backIntent = new Intent();
                            backIntent.putExtra(TRIANGLE_RESULT,area_string);
                            setResult(RESULT_OK,backIntent);
                            finish();
                    }
        }
        );
        ((Button)findViewById(R.id.backButton)).setOnClickListener(
                new View.OnClickListener(){
                    @Override

                    public void onClick(View view)
                    {
                        Intent backIntent = new Intent();

                        backIntent.putExtra(TRIANGLE_RESULT,"0.0");
                        setResult(RESULT_OK,backIntent);
                        finish();
                    }
                }
        );
}
}
