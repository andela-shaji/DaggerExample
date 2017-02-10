package com.example.suadahaji.booksapplication.api;

import com.example.suadahaji.booksapplication.dagger.qualifiers.ApiKey;
import com.example.suadahaji.booksapplication.dagger.qualifiers.ApiUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

@Module
public class ApiModule {
    @Provides @Singleton @ApiUrl String provideApiUrl() {
        return "http://api.nytimes.com/svc/books/";
    }

    @Provides @Singleton @ApiKey String provideApiKey() {
        return "852b2c14bb064a079aa98ebb5ef57660";
    }

    @Provides @Singleton
    OkHttpClient provideOkhttpClient() {
        return new OkHttpClient()
                        .newBuilder()
                        .build();
    }

    @Provides @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, @ApiUrl String baseUrl) {
        return new Retrofit.Builder()
                                .client(okHttpClient)
                                .baseUrl(baseUrl)
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io() ))
                                .build();
    }

    @Provides @Singleton ApiManager provideApiManager(Retrofit retrofit) {
        return retrofit.create(ApiManager.class);
    }
}
