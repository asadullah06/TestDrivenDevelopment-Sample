package com.example.testdrivendevelopment_sample.exampleOne;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

import com.example.testdrivendevelopment_sample.exampleOne.PingServerSyncUseCase.UseCaseResult;
import com.example.testdrivendevelopment_sample.exampleOne.networking.PingServerHttpEndpointSync;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PingServerSyncUseCaseTest {

    PingServerSyncUseCase SUT;

    @Mock
    PingServerHttpEndpointSync pingServerHttpEndpointSyncMock;

    @Before
    public void setup() {
        SUT = new PingServerSyncUseCase(pingServerHttpEndpointSyncMock);

        success();
    }


    @Test
    public void pingServerSync_success_successReturned() {
        UseCaseResult result = SUT.pingServer();

        MatcherAssert.assertThat(result, is(UseCaseResult.SUCCESS));
    }

    @Test
    public void pingServerSync_generalError_failureReturned() {
        generalError();
        UseCaseResult result = SUT.pingServer();

        MatcherAssert.assertThat(result, is(UseCaseResult.FAILURE));
    }

    private void success() {
        when(pingServerHttpEndpointSyncMock.pingServerSync()).thenReturn(PingServerHttpEndpointSync.EndpointResult.SUCCESS);
    }

    private void generalError() {
        when(pingServerHttpEndpointSyncMock.pingServerSync()).thenReturn(PingServerHttpEndpointSync.EndpointResult.GENERAL_ERROR);
    }

}
