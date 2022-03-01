package com.example.testdrivendevelopment_sample.exampleOne;


import com.example.testdrivendevelopment_sample.exampleOne.networking.PingServerHttpEndpointSync;

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
        return null;
    }
}
