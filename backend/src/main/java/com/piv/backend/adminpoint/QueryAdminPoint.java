package com.piv.backend.adminpoint;


import graphql.annotations.annotationTypes.GraphQLField;

public class QueryAdminPoint {

    @GraphQLField
    public Service service () {
        Service ans = new Service("1", "name", "token");
        return ans;
    }

}
