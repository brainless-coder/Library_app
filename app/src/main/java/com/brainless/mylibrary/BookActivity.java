package com.brainless.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private static final String TAG = "BookActivity";


    private TextView bookName, authorName, description, pageNumber;
    private ImageView bookImage;
    private Button btnCurReading, btnWantToRead, btnAlreadyRead;

    private Book incomingBook;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        overridePendingTransition(R.anim.in, R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId", 0);
        util = new Util();
        ArrayList<Book> books = util.getAllBooks();
        for (Book b: books) {
            if (b.getId() == id) {

                incomingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                description.setText(b.getDescription());
                pageNumber.setText("Pages: " + b.getPage());
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);
            }
        }

        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCurReadingTapped();
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlreadyReadTapped();
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWantToReadTapped();
            }
        });
    }

    private void btnWantToReadTapped() {
        Log.d(TAG, "btnWantToReadTapped: started");


        ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();


        if (wantToReadBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You already added this book to your Want to Read List");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(false);
            builder.create().show();
        }else {

            ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
            if (alreadyReadBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You already read this book.");
                builder.setTitle("Error");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setCancelable(false);
                builder.create().show();
            }else {
                ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();
                if (currentlyReadingBooks.contains(incomingBook)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("You are currently reading this book.");
                    builder.setTitle("Error");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setCancelable(false);
                    builder.create().show();
                }else {
                    util.addWantToReadBook(incomingBook);
                    Toast.makeText(this, "The Book " + incomingBook.getName() + " added to your Want to Read Shelf", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    private void btnAlreadyReadTapped() {
        Log.d(TAG, "btnAlreadyReadTapped: started");


        ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();


        if (alreadyReadBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You already added this book to your Already Read List");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(false);
            builder.create().show();
        }else {

            ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();
            if (currentlyReadingBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage("Have you finished Reading this Book?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeCurrentlyReadingBook(incomingBook);
                        util.addAlreadyReadBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The Book " + incomingBook.getName() + " added to your Already Read Shelf", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setCancelable(false);
                builder.create().show();
            } else {


                util.addAlreadyReadBook(incomingBook);
                Toast.makeText(this, "The Book " + incomingBook.getName() + " added to your Already Read Shelf", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void btnCurReadingTapped() {
        Log.d(TAG, "btnCurReadingTapped: started");


        ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();


        if (currentlyReadingBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You already added this book to your Currently Reading List");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(false);
            builder.create().show();
        }else {

            ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();

            if (wantToReadBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage("Are you going to start reading this book?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeWantToReadBook(incomingBook);
                        util.addCurrentlyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The Book " + incomingBook.getName() + " added to your Currently Reading Shelf", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setCancelable(false);
                builder.create().show();
            }else {
                ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();

                if (alreadyReadBooks.contains(incomingBook)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setMessage("Do you want to read this book Again?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            util.addCurrentlyReadingBook(incomingBook);
                            Toast.makeText(BookActivity.this, "The Book " + incomingBook.getName() + " added to your Currently Reading Shelf", Toast.LENGTH_SHORT).show();

                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setCancelable(false);
                    builder.create().show();
                }else {
                    util.addCurrentlyReadingBook(incomingBook);
                    Toast.makeText(this, "The Book " + incomingBook.getName() + " added to your Currently Reading Shelf", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void initWidgets() {
        bookName = findViewById(R.id.bookName);
        authorName = findViewById(R.id.authorName);
        description = findViewById(R.id.bookDesc);
        pageNumber = findViewById(R.id.bookPage);

        bookImage = findViewById(R.id.bookImage);

        btnCurReading = findViewById(R.id.btnCurrReading);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}
