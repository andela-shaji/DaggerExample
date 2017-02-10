package com.example.suadahaji.booksapplication.mvp_books;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.suadahaji.booksapplication.R;
import com.example.suadahaji.booksapplication.api.ApiManager;
import com.example.suadahaji.booksapplication.dagger.BooksApplication;
import com.example.suadahaji.booksapplication.model.Book;
import com.example.suadahaji.booksapplication.ui.BooksAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

public class BooksView extends RelativeLayout implements BooksContract {

    @Inject
    ApiManager apiManager;

    private final RecyclerView recyclerView;

    BooksPresenter booksPresenter;

    public BooksView(Context context, AttributeSet attrs) {
        this(context);
    }

    public BooksView(Context context) {
        super(context);
        final View view = LayoutInflater.from(context).inflate(R.layout.books_view, this, true);

        ((BooksApplication) getContext().getApplicationContext()).getAppComponent().inject(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.books_recycler_view);
        recyclerView.setHasFixedSize(true);

        booksPresenter = new BooksPresenter(apiManager, this);
        booksPresenter.fetchBooks();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        booksPresenter.unbind();
    }

    @Override
    public void onBookResponse(ArrayList<Book> books) {
        recyclerView.setAdapter(new BooksAdapter(books, R.layout.books_list_view, getContext()));

    }

    @Override
    public void displayEmptyState() {
        findViewById(R.id.empty_state).setVisibility(VISIBLE);
    }

    @Override
    public void displayErrorState() {
        findViewById(R.id.error_state).setVisibility(VISIBLE);
    }
}
