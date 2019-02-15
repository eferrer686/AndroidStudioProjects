package com.example.edfmg.recyclingplaces;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class SplashActivity extends AppCompatActivity {


    RequestOptions options;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);

        String image_URL = "https://static1.squarespace.com/static/534fe620e4b0337f7ff5c5da/t/58a2568003596e0ca1a065b5/1487035502103/";
        options = new RequestOptions();
        image = (ImageView) findViewById(R.id.imageView);
        Glide.with(this).load(image_URL).apply(options).into(image);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
