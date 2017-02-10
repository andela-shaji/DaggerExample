package com.example.suadahaji.booksapplication.api;


import com.example.suadahaji.booksapplication.model.BooksResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiManager {
    @GET("lists/best-sellers/history.json?api_key=852b2c14bb064a079aa98ebb5ef57660")
    Observable<BooksResponse> getBooks(@Query("api_key") String apiKey);
}
