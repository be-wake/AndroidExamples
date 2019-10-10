package com.example.a30_days_of_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Image_View extends AppCompatActivity {

    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__view);

        imageView1=findViewById(R.id.snake1);

        //Changing image Resource
        imageView1.setImageResource(R.drawable.snake2);


        // Changing layout height and width
        imageView1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,50));


        //Get and set scaleType
        ImageView.ScaleType scl=imageView1.getScaleType();
        imageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);

        // Scaling image to it's center
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ScaleAnimation(float fromX, float toX, float fromY, float toY, float pivotX, float pivotY)
                ScaleAnimation scl= new ScaleAnimation(0f,1f,0f,1f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scl.setDuration(1000);
                scl.setFillAfter(true);
                imageView1.startAnimation(scl);
            }
        });

        //Rotate image by some degree
        imageView1.setRotation(90);

        //Change background color of image
        imageView1.setBackgroundColor(Color.BLACK);

        //Loading large image in android
        //First load image in bitmap
//
//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.large_snake);
//        imageView1.setImageBitmap(bitmap);


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 3;
        BitmapFactory.decodeResource(getResources(), R.drawable.large_snake, options);

        options.inSampleSize =calculateInSampleSize(options, 500,500);
        options.inJustDecodeBounds = false;
        Bitmap smallBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.large_snake, options);



    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;

        int stretch_width = Math.round((float)width / (float)reqWidth);
        int stretch_height = Math.round((float)height / (float)reqHeight);

        if (stretch_width <= stretch_height)
            return stretch_height;
        else
            return stretch_width;
    }
    
    public ColorFilter getColorFilter (){
        setColorFilter(android.graphics.ColorFilter);//Returns the active color filter for this ImageView.
    }
}
