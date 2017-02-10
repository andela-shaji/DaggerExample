package com.example.suadahaji.booksapplication.mvp_books;


import com.example.suadahaji.booksapplication.model.Book;

import java.util.ArrayList;

public interface BooksContract {
    void onBookResponse(ArrayList<Book> books);
    void displayEmptyState();
    void displayErrorState();
}
