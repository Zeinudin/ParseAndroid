package com.example.parseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.InputStream;
import java.net.URL;

public class ImageParse extends AppCompatActivity {

    ImageView img;
    Button btn3;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_parse);

        img=(ImageView) findViewById(R.id.imageView);
        new Imageparse().execute();
        btn3=(Button)findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public class Imageparse extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            try {

//                bitmap = BitmapFactory.decodeStream((InputStream) new URL("https://iuca.kg/ru/nash-osnovatel/").getContent());
                bitmap = BitmapFactory.decodeStream((InputStream) new URL("https://auca.kg/uploads/00012021/Бекжон.jpg").getContent());
            }catch (Exception e){e.printStackTrace();}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            img.setImageBitmap(bitmap);
        }
    }

}