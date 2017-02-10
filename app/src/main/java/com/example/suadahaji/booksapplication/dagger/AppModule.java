package com.example.suadahaji.booksapplication.dagger;

import android.content.Context;

import com.example.suadahaji.booksapplication.dagger.qualifiers.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    final BooksApplication booksApplication;
    public AppModule(BooksApplication application) {
         this.booksApplication = application;
    }

    @Provides @ApplicationContext
    Context provideApplicationContext() {
        return booksApplication.getApplicationContext();
    }
}
