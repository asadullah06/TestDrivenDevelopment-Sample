package com.example.testdrivendevelopment_sample.exampleTwo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.testdrivendevelopment_sample.exampleTwo.networking.AddToCartHttpEndpointSync;
import com.example.testdrivendevelopment_sample.exampleTwo.networking.AddToCartHttpEndpointSync.EndpointResult;
import com.example.testdrivendevelopment_sample.exampleTwo.networking.CartItemScheme;
import com.example.testdrivendevelopment_sample.exampleTwo.networking.NetworkErrorException;

import org.hamcrest.MatcherAssert;
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

        success();
    }

    @Test
    public void addToCartSync_correctParametersPassedToEndpoint() throws Exception {
        ArgumentCaptor<CartItemScheme> ac = ArgumentCaptor.forClass(CartItemScheme.class);

        SUT.addToCartSync(OFFER_ID, AMOUNT);
        verify(addToCartHttpEndpointSyncMock).addToCartSync(ac.capture());
        assertThat(ac.getValue().getOfferId(), is(OFFER_ID));
        assertThat(ac.getValue().getAmount(), is(AMOUNT));
    }

    @Test
    public void addToCartSync_success_successReturned() {
        AddToCartUseCaseSync.UseCaseResult result = SUT.addToCartSync(OFFER_ID, AMOUNT);

        MatcherAssert.assertThat(result, is(AddToCartUseCaseSync.UseCaseResult.SUCCESS));
    }

    @Test
    public void addToCartSync_authError_failureReturned() throws NetworkErrorException {
        authError();
        AddToCartUseCaseSync.UseCaseResult result = SUT.addToCartSync(OFFER_ID, AMOUNT);

        MatcherAssert.assertThat(result, is(AddToCartUseCaseSync.UseCaseResult.FAILURE));
    }

    @Test
    public void addToCartSync_generalError_failureReturned() throws NetworkErrorException {
        generalError();
        AddToCartUseCaseSync.UseCaseResult result = SUT.addToCartSync(OFFER_ID, AMOUNT);

        MatcherAssert.assertThat(result, is(AddToCartUseCaseSync.UseCaseResult.FAILURE));
    }

    private void success() throws NetworkErrorException {
        when(addToCartHttpEndpointSyncMock.addToCartSync(any(CartItemScheme.class))).thenReturn(EndpointResult.SUCCESS);
    }

    private void authError() throws NetworkErrorException {
        when(addToCartHttpEndpointSyncMock.addToCartSync(any(CartItemScheme.class))).thenReturn(EndpointResult.AUTH_ERROR);
    }

    private void generalError() throws NetworkErrorException {
        when(addToCartHttpEndpointSyncMock.addToCartSync(any(CartItemScheme.class))).thenReturn(EndpointResult.GENERAL_ERROR);
    }

}