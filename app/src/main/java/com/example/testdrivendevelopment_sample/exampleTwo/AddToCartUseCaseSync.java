package com.example.testdrivendevelopment_sample.exampleTwo;

import com.example.testdrivendevelopment_sample.exampleTwo.networking.AddToCartHttpEndpointSync;
import com.example.testdrivendevelopment_sample.exampleTwo.networking.AddToCartHttpEndpointSync.EndpointResult;
import com.example.testdrivendevelopment_sample.exampleTwo.networking.CartItemScheme;
import com.example.testdrivendevelopment_sample.exampleTwo.networking.NetworkErrorException;

public class AddToCartUseCaseSync {

    private AddToCartHttpEndpointSync addToCartHttpEndpointSync;

    public enum UseCaseResult {
        SUCCESS,
        FAILURE,
        NETWORK_ERROR;
    }

    AddToCartUseCaseSync(AddToCartHttpEndpointSync addToCartHttpEndpointSync) {
        this.addToCartHttpEndpointSync = addToCartHttpEndpointSync;

    }

    public UseCaseResult addToCartSync(String offerId, int amount) {

        try {
            EndpointResult result = addToCartHttpEndpointSync.addToCartSync(new CartItemScheme(offerId, amount));

        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

}
