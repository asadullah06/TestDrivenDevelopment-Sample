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
    public void pingServerSync_success_successReturned() throws Exception {
        UseCaseResult result = SUT.pingServer();

        MatcherAssert.assertThat(result, is(UseCaseResult.SUCCESS));
    }

    @Test
    public void pingServerSync_generalError_failureReturned() throws Exception {
        generalError();
        UseCaseResult result = SUT.pingServer();

        MatcherAssert.assertThat(result, is(UseCaseResult.FAILURE));
    }

    @Test
    public void pingServerSync_networkError_failureReturned() throws Exception {
        networkError();
        UseCaseResult result = SUT.pingServer();

        MatcherAssert.assertThat(result, is(UseCaseResult.FAILURE));
    }

    @Test(expected = RuntimeException.class)
    public void pingServerSync_unknownError_exceptionRecorded() {
        unknownError();
        SUT.pingServer();
    }

    private void success() {
        when(pingServerHttpEndpointSyncMock.pingServerSync()).thenReturn(PingServerHttpEndpointSync.EndpointResult.SUCCESS);
    }

    private void generalError() {
        when(pingServerHttpEndpointSyncMock.pingServerSync()).thenReturn(PingServerHttpEndpointSync.EndpointResult.GENERAL_ERROR);
    }

    private void networkError() {
        when(pingServerHttpEndpointSyncMock.pingServerSync()).thenReturn(PingServerHttpEndpointSync.EndpointResult.NETWORK_ERROR);
    }

    private void unknownError() {
        when(pingServerHttpEndpointSyncMock.pingServerSync()).thenReturn(PingServerHttpEndpointSync.EndpointResult.UNKNOWN_ERROR);
    }

}
