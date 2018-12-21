package com.example.admin.imagecropping;

import  android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;

public class Crop extends AppCompatActivity
{
    CropImageView cropImageView;
    Button cropFour,cropOne,cropTwo,cropThree,crop,cropFive;
    Bundle b;
    Uri uri;
    String x;
    Bitmap cropped;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        init();

        b = getIntent().getExtras();
        x = b.getString("x");

        uri = Uri.parse(x);
        cropImageView.setImageUriAsync(uri);

        cropOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cropImageView.setAspectRatio(1,1);
            }
        });

        cropTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cropImageView.setAspectRatio(4,3);
            }
        });

        cropThree.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cropImageView.setAspectRatio(16,9);
            }
        });

        cropFour.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cropImageView.setFixedAspectRatio(false);
            }
        });

        cropFive.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cropImageView.setAspectRatio(3,2);
            }
        });

        crop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cropped = cropImageView.getCroppedImage();

                ByteArrayOutputStream bs =  new ByteArrayOutputStream();
                cropped.compress(Bitmap.CompressFormat.PNG,100,bs);
                byte[] b = bs.toByteArray();

                Intent intent = new Intent(Crop.this,Display.class);
                intent.putExtra("picture",b);
                startActivity(intent);
            }
        });
    }

    private void init() {
        cropImageView = findViewById(R.id.cropImageView);
        cropFour = findViewById(R.id.cropFour);
        cropOne = findViewById(R.id.cropOne);
        cropTwo = findViewById(R.id.cropTwo);
        cropThree = findViewById(R.id.cropThree);
        crop = findViewById(R.id.crop);
        cropFive = findViewById(R.id.cropFive);
    }

    @Override
    protected void onResume()
    {
        cropImageView.setImageUriAsync(uri);
        cropImageView.setFixedAspectRatio(false);
        super.onResume();
    }
}
