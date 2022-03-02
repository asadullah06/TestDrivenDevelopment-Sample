package com.example.testdrivendevelopment_sample.exampleTwo.networking;

public interface AddToCartHttpEndpointSync {

    EndpointResult addToCartSync(CartItemScheme cartItemScheme) throws NetworkErrorException;

    enum EndpointResult {
        SUCCESS,
        AUTH_ERROR,
        GENERAL_ERROR,
        UNKNOWN_ERROR
    }

}
