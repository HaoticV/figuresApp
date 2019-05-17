package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class Rectangle{
    private double a,b;
    Rectangle(double _a, double _b){a=_a;b=_b;}

    double area(){
        double p =2*a+2*b;
        return p;
    }
}
public class rectangle extends AppCompatActivity {
    public final static String RECTANGLE_RESULT="Area of TriangleActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        ((Button) findViewById(R.id.rectangleCalcButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a= Double.parseDouble(((EditText)findViewById(R.id.aaEitText)).getText().toString());
                double b= Double.parseDouble(((EditText)findViewById(R.id.bbEditText)).getText().toString());
                Rectangle rectangle= new Rectangle(a,b);
                ((TextView)findViewById(R.id.rectangleResultTextView)).setText(Double.toString(rectangle.area()));
            }
        });
        ((Button)findViewById(R.id.backAndAddButton)).setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        String area_string=((TextView)findViewById(R.id.rectangleResultTextView))
                                .getText().toString();

                        Intent backIntent = new Intent();
                        backIntent.putExtra(RECTANGLE_RESULT,area_string);
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

                        backIntent.putExtra(RECTANGLE_RESULT,"0.0");
                        setResult(RESULT_OK,backIntent);
                        finish();
                    }
                }
        );
    }
}
