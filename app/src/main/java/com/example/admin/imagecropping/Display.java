package com.example.admin.imagecropping;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Display extends AppCompatActivity
{
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageView = findViewById(R.id.display);

        Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("picture");
        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);

        Resize();

        imageView.setImageBitmap(bitmap);
    }

    private void Resize()
    {
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width * 790 / 1080, height * 700 / 1920);
        imageView.setLayoutParams(params);
    }
}
