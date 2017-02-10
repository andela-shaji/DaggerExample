package com.example.suadahaji.booksapplication.ui;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suadahaji.booksapplication.R;
import com.example.suadahaji.booksapplication.model.Book;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksHolder> {

    private ArrayList<Book> books;
    int rowLayout;
    Context context;

    private static final String TAG = "BooksAdapter";

    public BooksAdapter(ArrayList<Book> books, int rowLayout, Context context) {
        this.books = books;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public class BooksHolder extends RecyclerView.ViewHolder {
        TextView bookTitle;
        TextView bookAuthor;

        public BooksHolder(View itemView) {
            super(itemView);
            bookTitle = (TextView) itemView.findViewById(R.id.book_title);
            bookAuthor = (TextView) itemView.findViewById(R.id.book_author);
        }
    }
    @Override
    public BooksHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.books_list_view, parent, false);
        return new BooksHolder(view);
    }

    @Override
    public void onBindViewHolder(BooksHolder holder, int position) {
        holder.bookTitle.setText(books.get(position).getTitle());
        holder.bookAuthor.setText(books.get(position).getAuthor());

        Log.d(TAG, "Title is " + books.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }


}
