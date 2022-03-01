package com.example.testdrivendevelopment_sample.exampleOne;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

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
        PingServerSyncUseCase.UseCaseResult result = SUT.pingServer();

        MatcherAssert.assertThat(result, is(PingServerSyncUseCase.UseCaseResult.SUCCESS));
    }

    @Test
    public void testing(){
        assertTrue(true);
    }
    private void success() {
        when(pingServerHttpEndpointSyncMock.pingServerSync()).thenReturn(PingServerHttpEndpointSync.EndpointResult.GENERAL_ERROR);
    }


}
