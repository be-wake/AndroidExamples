package com.example.a30_days_of_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class DayOne extends AppCompatActivity {

    TextView textView;
    //Declaring a textview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_one);

        textView=findViewById(R.id.hellotext);

        changeTextView(textView);

    }
    public void changeTextView(TextView textView){
        //Change the text of TextView
        textView.setText("Hello Noobie");
        //Change the size of textView
        textView.setTextSize(24);
        //In pixels
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,24);
        //In dp or dip
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
        //In inch
        textView.setTextSize(TypedValue.COMPLEX_UNIT_IN,0.50f);
        //In points
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PT,24);
        //In mm
        textView.setTextSize(TypedValue.COMPLEX_UNIT_MM,24);
        //Using resources
        textView.setTextSize(getResources().getDimension(R.dimen.textsize));
        //Using Resources
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimension(R.dimen.textsize));

    }
}
