package com.example.suadahaji.booksapplication.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.suadahaji.booksapplication.R;
import com.example.suadahaji.booksapplication.dagger.BooksApplication;
import com.example.suadahaji.booksapplication.dagger.qualifiers.ApiKey;

import javax.inject.Inject;

public class BookListActivity extends AppCompatActivity {

    @Inject @ApiKey String apiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((BooksApplication) getApplicationContext()).getAppComponent().inject(this);

        if (apiKey.isEmpty()) {
            Toast.makeText(getApplicationContext(),  "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG);
            return;
        }

        setFragment(new BookListFragment());
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }
}
