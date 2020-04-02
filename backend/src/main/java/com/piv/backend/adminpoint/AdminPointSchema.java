package com.piv.backend.adminpoint;

import graphql.annotations.AnnotationsSchemaCreator;
import graphql.schema.GraphQLSchema;

public class AdminPointSchema {

    private AnnotationsSchemaCreator.Builder builder = AnnotationsSchemaCreator.newAnnotationsSchema();
    private GraphQLSchema graphQLSchema;


    public GraphQLSchema getGraphQLSchema() {
        return  this.graphQLSchema;
    }

    public AdminPointSchema() {
        this.graphQLSchema = builder
                .query(QueryAdminPoint.class)
                .setAlwaysPrettify(true)
                .build();
    }
}
