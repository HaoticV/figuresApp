package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class Circle
{
    private double r;
    Circle(double _r){r=_r;}

    double area()
    {
        double p=3.14*r*r;
        return p;
    }
}

public class circle extends AppCompatActivity {

    public final static String CIRCLE_RESULT="Area of triangle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        ((Button) findViewById(R.id.circleCalcButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double r= Double.parseDouble(((EditText)findViewById(R.id.rEditText)).getText().toString());

                Circle c= new Circle(r);
                ((TextView)findViewById(R.id.circleResultTextView)).setText(Double.toString(c.area()));
            }
        });
        ((Button)findViewById(R.id.backAndAddButton)).setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        String area_string=((TextView)findViewById(R.id.circleResultTextView))
                                .getText().toString();

                        Intent backIntent = new Intent();
                        backIntent.putExtra(CIRCLE_RESULT,area_string);
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

                        backIntent.putExtra(CIRCLE_RESULT,"0.0");
                        setResult(RESULT_OK,backIntent);
                        finish();
                    }
                }
        );
    }
}
