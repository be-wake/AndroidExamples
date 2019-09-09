package com.example.a30_days_of_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Image_View extends AppCompatActivity {

    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__view);

        imageView1=findViewById(R.id.snake1);

        imageView1.setImageResource(R.drawable.snake2);
    }
}
