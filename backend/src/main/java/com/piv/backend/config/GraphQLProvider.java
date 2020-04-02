package com.piv.backend.config;

import com.piv.backend.adminpoint.AdminPointSchema;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GraphQLProvider {

    private AdminPointSchema adminPointSchema = new AdminPointSchema();

    private GraphQL graphQL;

    @PostConstruct
    public void init() {
        GraphQLSchema graphQLSchema = adminPointSchema.getGraphQLSchema();
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }
    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}
