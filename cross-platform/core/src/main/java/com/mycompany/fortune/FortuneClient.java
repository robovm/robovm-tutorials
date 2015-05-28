package com.mycompany.fortune;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;

public class FortuneClient {
    private static final String API_URL = "http://www.iheartquotes.com/api/v1/";

    private class Fortune {
        public String quote;
    }

    private interface FortuneService {
        @GET("/random?format=json")
        void getFortune(Callback<Fortune> callback);
    }

    public static class OnFortuneListener {
        public void onFortune(String fortune) {
        }
    }

    private FortuneService service;

    public FortuneClient() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        service = adapter.create(FortuneService.class);
    }

    public void getFortune(final OnFortuneListener listener) {
        service.getFortune(new Callback<Fortune>() {
            @Override
            public void success(Fortune fortune, Response response) {
                listener.onFortune(fortune.quote);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFortune(error.toString());
            }
        });
    }
}
