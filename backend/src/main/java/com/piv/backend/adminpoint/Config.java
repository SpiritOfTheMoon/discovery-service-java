package com.piv.backend.adminpoint;

import graphql.annotations.annotationTypes.GraphQLField;

public class Config {
    @GraphQLField
    public String id;

    @GraphQLField
    public String name;

    public Config(String id, String name) {
        this.id = id;
        this.name = name;
    }
}


