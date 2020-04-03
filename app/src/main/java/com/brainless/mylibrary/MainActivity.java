package com.brainless.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button btnSeeAll, btnCurrentlyReading, btnWantToRead, btnAlreadyRead, btnAbout;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setOnclickListeners();
    }

    private void setOnclickListeners() {
        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
                startActivity(intent);
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantToActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutTapped();
            }
        });
    }

    private void aboutTapped() {
        Log.d(TAG, "aboutTapped: started");

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("About My Library App")
                .setMessage("This app is Build and Published by Brainless Coders\n\n" +
                        "You can maintain all your books in this App.\n\n" +
                        "If you want to hire me, " +
                        "You can contact me on whatsapp at 7663016721.\n\n" +
                        "You can also visit brainlesscoders.000webhostapp.com")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, MyWebViewActivity.class);
                        intent.putExtra("url", "https://www.google.com/");
                        startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();
    }

    private void initWidgets() {
        btnSeeAll = findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrent);
        btnWantToRead = findViewById(R.id.btnWantTo);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnAbout = findViewById(R.id.btnAbout);
    }
}
