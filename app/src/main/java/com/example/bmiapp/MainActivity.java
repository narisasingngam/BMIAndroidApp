package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView bmiValue;
    private ImageView image;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bmiValue = (TextView) findViewById(R.id.bmiValue);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        calculate = (Button) findViewById(R.id.calculate);
    }

    public void calBMI(View view){
        image = (ImageView) findViewById(R.id.image);

        if( height == null && weight == null) return;

        String heightText = height.getText().toString();
        String weightText = weight.getText().toString();

        double heightValue = Integer.parseInt(heightText);
        double weightValue = Integer.parseInt(weightText);
        if( heightValue == 0 || weightValue == 0) return;
        double bmi = weightValue/Math.pow(heightValue/100,2);

        bmiValue.setText(String.format("%.2f", bmi));

        if (bmi < 22){
            image.setImageResource(R.drawable.underweight);
            image.setVisibility(View.VISIBLE);
        } else if(bmi >=22 && bmi <= 30){
            image.setImageResource(R.drawable.healthyrange);
            image.setVisibility(View.VISIBLE);
        } else {
            image.setImageResource(R.drawable.overobese);
            image.setVisibility(View.VISIBLE);
        }

        calculate.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }
}
