package com.example.testdrivendevelopment_sample.exampleOne;


import com.example.testdrivendevelopment_sample.exampleOne.networking.PingServerHttpEndpointSync;
import com.example.testdrivendevelopment_sample.exampleOne.networking.PingServerHttpEndpointSync.EndpointResult;

public class PingServerSyncUseCase {

    public enum UseCaseResult {
        FAILURE,
        SUCCESS
    }

    private PingServerHttpEndpointSync pingServerHttpEndpointSync;

    PingServerSyncUseCase(PingServerHttpEndpointSync pingServerHttpEndpointSync) {
        this.pingServerHttpEndpointSync = pingServerHttpEndpointSync;

    }

    public UseCaseResult pingServer() {
        EndpointResult result = pingServerHttpEndpointSync.pingServerSync();
        if (result == EndpointResult.SUCCESS)
            return UseCaseResult.SUCCESS;
        else return null;
    }
}
