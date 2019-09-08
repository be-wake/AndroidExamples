package com.example.a30_days_of_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
        editText1.setTextColor(Color.CYAN);

        //change BackGround color

        editText1.setBackgroundColor(Color.YELLOW);

        //You can change color of hint, cursor,link;

        //You can change the color of underline of edit text
        editText1.setBackgroundTintMode(PorterDuff.Mode.OVERLAY);

        /*
        What is PorterDuff.Mode

        https://stackoverflow.com/questions/8280027/what-does-porterduff-mode-mean-in-android-graphics-what-does-it-do
         */


    }
}
