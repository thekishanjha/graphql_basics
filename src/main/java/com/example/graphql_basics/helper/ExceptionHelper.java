package com.example.graphql_basics.helper;

public class ExceptionHelper {

    public static RuntimeException throwResourceNotFoundException(){
        return new RuntimeException("Resource not found!!");
    }
}
