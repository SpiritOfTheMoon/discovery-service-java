package com.piv.backend.adminpoint;

import graphql.annotations.annotationTypes.GraphQLField;
import org.dataloader.DataLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Service {

    private DataLoader<String, List<Config>> configsLoader = new DataLoader<>((keys)-> {

        CompletionStage<List<List<Config>>> future = CompletableFuture.supplyAsync(()->{
            List<List<Config>> answer = new ArrayList<>(new ArrayList<>());
            return answer;
        });
        return future;
    });

    @GraphQLField
    public String id;

    @GraphQLField
    public String name;

    @GraphQLField
    public String token;

    public Service(String id, String name, String token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    @GraphQLField
    public List<Config> configs () {
        List<Config> answer = configsLoader.load(this.id).join();
        return answer;
    }
}
