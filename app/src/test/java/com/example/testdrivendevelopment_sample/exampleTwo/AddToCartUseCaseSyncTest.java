package com.example.testdrivendevelopment_sample.exampleTwo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import com.example.testdrivendevelopment_sample.exampleTwo.networking.AddToCartHttpEndpointSync;
import com.example.testdrivendevelopment_sample.exampleTwo.networking.CartItemScheme;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AddToCartUseCaseSyncTest {

    private AddToCartUseCaseSync SUT;

    private static final String OFFER_ID = "offerId";
    private static final int AMOUNT = 4;

    @Mock
    private AddToCartHttpEndpointSync addToCartHttpEndpointSyncMock;


    @Before
    public void setUp() throws Exception {
        SUT = new AddToCartUseCaseSync(addToCartHttpEndpointSyncMock);


    }

    @Test
    public void addToCartSync_correctParametersPassedToEndpoint() throws Exception{
        ArgumentCaptor<CartItemScheme> ac = ArgumentCaptor.forClass(CartItemScheme.class);

        SUT.addToCartSync(OFFER_ID, AMOUNT);
        verify(addToCartHttpEndpointSyncMock).addToCartSync(ac.capture());
        assertThat(ac.getValue().getOfferId(), is(OFFER_ID));
        assertThat(ac.getValue().getAmount(), is(AMOUNT));
    }
}