package com.piv.backend.adminpoint;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AdminPointProvider {

    private GraphQL graphQL;

    @Autowired
    GraphQLSchema adminPointGraphQLSchema;

    @PostConstruct
    public void init() {
        this.graphQL = GraphQL.newGraphQL(adminPointGraphQLSchema).build();
    }
    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

}
