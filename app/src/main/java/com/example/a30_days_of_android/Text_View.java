package com.example.a30_days_of_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView textView,sectextView;
    //Declaring a textView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        textView=findViewById(R.id.hellotext);
        sectextView=findViewById(R.id.hellotex3);

        changeTextView(textView);
        changeStyleAndColor(textView);
        variousTextOperations(textView);

    }

    private void variousTextOperations(TextView textView) {
        //Insert HTML formatting

        String formattedText = "This <i>is</i> a <b>link</b> of <a href='http://foo.com'>html</a>";
        // or getString(R.string.htmlFormattedText);

            textView.setText(Html.fromHtml(formattedText));

        //Displaying Images within a TextView
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_people_black_24dp,0,0,0);

        //Or
        Drawable img = getApplicationContext().getResources().getDrawable( R.drawable.ic_people_black_24dp );
        textView.setCompoundDrawablesWithIntrinsicBounds( img, null, null, null);


        //Using Span for styling of text
        String string=textView.getText().toString();
        //Span that will change the text color
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                getResources().getColor(android.R.color.holo_blue_dark));

        // Use a SpannableStringBuilder so that both the text and the spans are mutable
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);

        spannableStringBuilder.setSpan(foregroundColorSpan,0,string.length(), Spanned.SPAN_COMPOSING);

        //Strike the text
        StrikethroughSpan strike=new StrikethroughSpan();
        spannableStringBuilder.setSpan(strike,0,string.length(),Spanned.SPAN_COMPOSING);

        textView.setText(spannableStringBuilder, TextView.BufferType.EDITABLE);
        //

        //ClickableSpan

        SpannableString spannableString=new SpannableString("Hello Android");

        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(getApplicationContext(), "Hello Android", Toast.LENGTH_SHORT).show();
            }
        };
        spannableString.setSpan(clickableSpan, 10, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }


    private void changeStyleAndColor(TextView textView) {
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


        //Text Truncation
        //Change ellipsize

        textView.setEllipsize(TextUtils.TruncateAt.END);

        //setMaxLines
        textView.setMaxLines(6);
        //
        //Add shadow to text
         /*
                    public void setShadowLayer (float radius, float dx, float dy, int color)

                    Gives the text a shadow of the specified blur radius and
                    color, the specified distance from its drawn position.

                    shadowColor
                        Place a blurred shadow of text underneath the text,
                        drawn with the specified color.
                    shadowDx
                        Horizontal offset of the text shadow.
                    shadowDy
                        Vertical offset of the text shadow.
                    shadowRadius
                        Blur radius of the text shadow.
                 */

        textView.setShadowLayer(1.5f,0.5f,0.5f,Color.CYAN);

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
