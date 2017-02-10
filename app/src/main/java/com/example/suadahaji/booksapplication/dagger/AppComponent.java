package com.example.suadahaji.booksapplication.dagger;

import com.example.suadahaji.booksapplication.api.ApiModule;
import com.example.suadahaji.booksapplication.mvp_books.BooksView;
import com.example.suadahaji.booksapplication.ui.BookListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(BooksApplication application);

    void inject(BooksView booksView);

    void inject(BookListActivity bookListActivity);

    final class Initializer {
        private Initializer() {
        }

        static AppComponent init(BooksApplication app) {
              return DaggerAppComponent.builder()
                      .appModule(new AppModule(app))
                      .build();
            }
    }

}
