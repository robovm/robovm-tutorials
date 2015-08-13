package com.mycompany.fortune;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;

import java.util.List;
import java.util.Random;

public class FortuneClient {
    private static final String API_URL = "http://www.reddit.com";

    static class Data {
        Data data;
        String title;
        List<Data> children;
    }

    private interface FortuneService {
        @GET("/r/quotes.json")
        void getFortune(Callback<Data> callback);
    }

    public static class OnFortuneListener {
        public void onFortune(String fortune) {
        }
    }

    private static Random rng = new Random();

    private FortuneService service;

    public FortuneClient() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        service = adapter.create(FortuneService.class);
    }

    public void getFortune(final OnFortuneListener listener) {
        service.getFortune(new Callback<Data>() {
            @Override
            public void success(Data json, Response response) {
                List<Data> fortunes = json.data.children;
                Data fortune = fortunes.get(rng.nextInt(fortunes.size()));
                listener.onFortune(fortune.data.title);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFortune(error.toString());
            }
        });
    }
}

