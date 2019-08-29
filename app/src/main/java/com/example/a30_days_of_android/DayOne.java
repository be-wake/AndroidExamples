package com.example.a30_days_of_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
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

        //DayTwo

        //Change the layout height and width
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,0));
        //LinearLayout.LayoutParams(int width, int height, float weight)
        //Creates a new set of layout parameters with the specified width, height and weight.
        //Setting height and width from resources(dimensions)
        textView.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.textview_width),getResources().getDimensionPixelSize(R.dimen.textview_height),0));
        //
        textView.getLayoutParams().height=45;
        textView.getLayoutParams().width=45;
        textView.setLayoutParams(textView.getLayoutParams());
        //
        //Autosizing the textView
        //You can use app:autoSizeTextType="uniform" in textview in xml
        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        //Using Granularity
        //In Granularity, The TextView can uniformly scale, in a range between the given minimum and maximum size attributes.
        // Each increment takes on the step size specified in the granularity attribute.
        //TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(TextView textview, int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView,24,45,2,TypedValue.COMPLEX_UNIT_DIP);

        //By using preset sizes, you can autosize the TextView from a list of predefined sizes.
        int[] sizes=getApplicationContext().getResources().getIntArray(R.array.auto_textsize_array);
        TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(textView,sizes,TypedValue.COMPLEX_UNIT_DIP);
    }
}
