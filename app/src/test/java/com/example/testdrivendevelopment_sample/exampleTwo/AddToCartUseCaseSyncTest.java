package com.example.testdrivendevelopment_sample.exampleTwo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AddToCartUseCaseSyncTest {

    private AddToCartUseCaseSync SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new AddToCartUseCaseSync();
    }
}