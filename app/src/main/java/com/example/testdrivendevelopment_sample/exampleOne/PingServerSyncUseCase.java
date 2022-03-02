package com.example.testdrivendevelopment_sample.exampleOne;


import com.example.testdrivendevelopment_sample.exampleOne.networking.PingServerHttpEndpointSync;
import com.example.testdrivendevelopment_sample.exampleOne.networking.PingServerHttpEndpointSync.EndpointResult;

public class PingServerSyncUseCase {

    public enum UseCaseResult {
        FAILURE,
        SUCCESS
    }

    private final PingServerHttpEndpointSync pingServerHttpEndpointSync;

    PingServerSyncUseCase(PingServerHttpEndpointSync pingServerHttpEndpointSync) {
        this.pingServerHttpEndpointSync = pingServerHttpEndpointSync;

    }

    public UseCaseResult pingServer() {
        EndpointResult result = pingServerHttpEndpointSync.pingServerSync();


        switch (result) {
            case SUCCESS:
                return UseCaseResult.SUCCESS;
            case GENERAL_ERROR:
            case NETWORK_ERROR:
                return UseCaseResult.FAILURE;
            default:
                throw new RuntimeException("Invalid result " + result);
        }
    }
}
