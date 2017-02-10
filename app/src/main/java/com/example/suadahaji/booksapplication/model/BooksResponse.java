package com.example.suadahaji.booksapplication.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BooksResponse {
    @SerializedName("headers")
    @Expose
    private Headers headers;

    @SerializedName("body")
    private ArrayList<Book> books;

    public Headers getHeaders() {
        return headers;
    }

    public BooksResponse(Headers headers, ArrayList<Book> books) {
        this.headers = headers;
        this.books = books;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
