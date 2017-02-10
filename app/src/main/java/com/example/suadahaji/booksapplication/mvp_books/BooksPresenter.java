package com.example.suadahaji.booksapplication.mvp_books;

import com.example.suadahaji.booksapplication.api.ApiManager;
import com.example.suadahaji.booksapplication.model.Book;
import com.example.suadahaji.booksapplication.model.BooksResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class BooksPresenter {
    @Inject
    ApiManager apiManager;

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    private BooksContract booksContract;

    public final static String API_KEY = "e5730a2d7bb34e0d959d1988a38d9077";

    public BooksPresenter(ApiManager apiManager, BooksContract booksContract) {
        this.apiManager = apiManager;
        this.booksContract = booksContract;
    }

    void fetchBooks() {
        final Observable<BooksResponse> booksResponseObservable = apiManager.getBooks(API_KEY);
        compositeSubscription.add(booksResponseObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BooksResponse>() {
                    @Override
                    public void call(BooksResponse booksResponse) {
                        if (booksResponse == null || booksResponse.getBooks() == null || booksResponse.getBooks().size() == 0) {
                            booksContract.displayEmptyState();
                        }
                        ArrayList<Book> movies = booksResponse.getBooks();
                        booksContract.onBookResponse(movies);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        booksContract.displayErrorState();
                    }
                }));

    }

    void unbind() {
        compositeSubscription.unsubscribe();
    }

}
