package com.example.testdrivendevelopment_sample.exampleOne.networking;


public interface PingServerHttpEndpointSync {

    enum EndpointResult {
        SUCCESS,
        GENERAL_ERROR,
        NETWORK_ERROR,
        UNKNOWN_ERROR
    }

    EndpointResult pingServerSync();


}
