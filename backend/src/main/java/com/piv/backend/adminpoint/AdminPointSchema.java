package com.piv.backend.adminpoint;

import graphql.annotations.AnnotationsSchemaCreator;
import graphql.annotations.processor.GraphQLAnnotations;
import graphql.schema.GraphQLCodeRegistry;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AdminPointSchema {

    private AnnotationsSchemaCreator.Builder builder = AnnotationsSchemaCreator.newAnnotationsSchema();
    private GraphQLSchema adminPointGraphQLSchema;

    private GraphQLAnnotations graphQLAnnotations = new GraphQLAnnotations();
    SchemaGenerator schemaGenerator = new SchemaGenerator();

    @Bean
    public GraphQLSchema adminPointGraphQLSchema() {
        return this.adminPointGraphQLSchema;
    }

    public AdminPointSchema() {
        GraphQLObjectType query = graphQLAnnotations.object(QueryAdminPoint.class);
        GraphQLObjectType config = graphQLAnnotations.object(Config.class);
        GraphQLObjectType service = graphQLAnnotations.object(Service.class);
        GraphQLCodeRegistry graphQLCodeRegistry = graphQLAnnotations.getContainer().getCodeRegistryBuilder().build();
        this.adminPointGraphQLSchema = GraphQLSchema.newSchema().query(query).codeRegistry(graphQLCodeRegistry).build();
    }
}
