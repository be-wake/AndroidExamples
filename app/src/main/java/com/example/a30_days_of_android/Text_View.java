package com.example.a30_days_of_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Text_View extends AppCompatActivity {

//ColorList
    int[][] states = new int[][] {
            new int[] { android.R.attr.state_enabled}, // enabled
            new int[] {-android.R.attr.state_enabled}, // disabled
            new int[] {-android.R.attr.state_checked}, // unchecked
            new int[] { android.R.attr.state_pressed}  // pressed
    };

    int[] colors = new int[] {
            Color.BLACK,
            Color.RED,
            Color.GREEN,
            Color.BLUE
    };
    ColorStateList colorStateList=new ColorStateList(states,colors);
 //
    TextView textView;
    //Declaring a textView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        textView=findViewById(R.id.hellotext);

        changeTextView(textView);
        changeStyleColor(textView);

    }



    private void changeStyleColor(TextView textView) {
        //Change TextColor
        textView.setTextColor(Color.rgb(255,0,0));
        textView.setTextColor(Color.GREEN);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
        //If you are in an adapter and still want to use a color defined in resources you can try this
       // holder.text.setTextColor(holder.text.getContext().getResources().getColor(R.color.colorAccent));

        //ColorStateList
        /*A ColorStateList is an object you can define in XML that you can apply as a color,
         but will actually change colors,
         depending on the state of the View object to which it is applied*/

        textView.setTextColor(colorStateList);

        //get ColorStateList from resources
//        textView.setTextColor(getResources().getColorStateList(R.color.));

        //setHintTextColor
        textView.setHintTextColor(Color.RED);


        //Change Background Color
        textView.setBackgroundColor(Color.RED);

        //Change Background
        textView.setBackgroundResource(R.color.colorAccent);
        textView.setBackgroundResource(R.drawable.rounded_corner_textview);
        //If you hve resource id then you can also use

        //textView.setBackground();

        //Difference between setBackground and setBackGroundResource
        //https://stackoverflow.com/questions/18101390/what-is-the-difference-between-setbackgroundresource-and-setbackgrounddrawable

        //Change HighlightColor
        textView.setHighlightColor(Color.BLUE);

        //Change Font style of textView
        textView.setTypeface(null,Typeface.ITALIC);

        // If you want to keep the previous typeface and don't want to lose previously applied then
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD_ITALIC);
        //Change Gravity
        textView.setGravity(Gravity.CENTER|Gravity.BOTTOM);


    }

    public void changeTextView(TextView textView){
        //Change the text of Text_View
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
        //Auto sizing the textView
        //You can use app:autoSizeTextType="uniform" in textview in xml
        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        //Using Granularity
        //In Granularity, The Text_View can uniformly scale, in a range between the given minimum and maximum size attributes.
        // Each increment takes on the step size specified in the granularity attribute.
        //TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(Text_View textview, int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView,24,45,2,TypedValue.COMPLEX_UNIT_DIP);

        //By using preset sizes, you can autosize the Text_View from a list of predefined sizes.
        int[] sizes=getApplicationContext().getResources().getIntArray(R.array.auto_textsize_array);
        TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(textView,sizes,TypedValue.COMPLEX_UNIT_DIP);

    }
}
