package com.example.testdrivendevelopment_sample.exampleOne;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PingServerSyncUseCaseTest {

    PingServerSyncUseCase SUT;

    @Before
    public void setup(){
        SUT = new PingServerSyncUseCase();
    }

}
