package com.example.a30_days_of_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.EditText;
import android.widget.TextView;

public class EditText_View extends AppCompatActivity {

    EditText editText1;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text__view);
        editText1=findViewById(R.id.editText1);
        // Get text from edit text;
        String text=editText1.getText().toString();

        char arr[]= text.toCharArray();

        //Set text to edit Text
        //public void setText (CharSequence text, TextView.BufferType type)
        // TextView.BufferType: a TextView.BufferType which defines whether the text is stored as a static text, styleable/spannable text, or editable text

        CharSequence chr=arr.toString();
        //CharSequence are slightly different than strings

        editText1.setText(chr);

        editText1.setText(text, TextView.BufferType.SPANNABLE);
        /*Difference between  different buffer type
            https://stackoverflow.com/questions/40348088/textview-buffertype
         */
        //from String Resource
        editText1.setText(R.string.simple_text);

        // from char array;
        editText1.setText(arr,0,arr.length);

        //Change the color of input Text
        edittext1.setTextColor(Color.rgb(223,0,0));
        editText1.setTextColor(Color.CYAN);
        editText1.setTextColor(Color.parseColor("#000000"));
        editText1.setTextColor(getResources().getColor(R.color.colorPrimary));

        //change BackGround color

        editText1.setBackgroundColor(Color.YELLOW);

        //You can change color of hint, cursor,link;
        //setHintTextColor
        edittext1.setHintTextColor(Color.CYAN);
        editText1.sette

        //You can change the color of underline of edit text
        editText1.setBackgroundTintMode(PorterDuff.Mode.OVERLAY);
        //Change Font style of edittext
        editText1.setTypeface(null,Typeface.ITALIC);
        //setMaxLines
        edittext1.setMaxLines(4);
        //Change Gravity
        editText1.setGravity(Gravity.CENTER|Gravity.BOTTOM);

        //Change the size of textView
        editText1.setTextSize(56);
        //In pixels
        editText1.setTextSize(TypedValue.COMPLEX_UNIT_PX,12);
        //In dp or dip
        editText1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,11);
        //In inch
        edittext1.setTextSize(TypedValue.COMPLEX_UNIT_IN,0.50f);
        //In points
        editText1.setTextSize(TypedValue.COMPLEX_UNIT_PT,30);
        //In mm
        editText1.setTextSize(TypedValue.COMPLEX_UNIT_MM,30);
    
        /*
        What is PorterDuff.Mode

        https://stackoverflow.com/questions/8280027/what-does-porterduff-mode-mean-in-android-graphics-what-does-it-do
         */


    }
}
