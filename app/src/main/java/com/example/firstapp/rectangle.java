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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
    }
}
