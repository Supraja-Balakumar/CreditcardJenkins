package com.supraja.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;


import com.supraja.restapp.model.CardRequest;
import com.supraja.restapp.model.User;
import com.supraja.restapp.repoimpl.CardRequestRepoimpl;

public class CardRequestServiceImplTest {

    @Mock
    private CardRequestRepoimpl cardRequestRepo;

    @InjectMocks
    private CardRequestServiceImpl cardRequestService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testAddCardRequest() {
//        CardRequest cardRequest = new CardRequest(1, "Gold", "Software Engineer", "90000", "Checking", "123456789", "Pending", new User());
//
//        when(cardRequestRepo.save(cardRequest)).thenReturn(cardRequest);
//
//        String result = cardRequestService.addCardRequest(cardRequest);
//        assertEquals("AddSuccess", result);
//
//        verify(cardRequestRepo, times(1)).save(cardRequest);
//    }

    @Test
    void testGetCardRequest() {
        CardRequest cardRequest = new CardRequest(1, "Gold", "Software Engineer", "90000", "Checking", "123456789", "Pending", new User());

        when(cardRequestRepo.findById(1)).thenReturn(cardRequest);

        CardRequest result = cardRequestService.getCardRequest(1);
        assertNotNull(result);
        assertEquals(1, result.getCardid());
        assertEquals("Gold", result.getCardtype());

        verify(cardRequestRepo, times(1)).findById(1);
    }

    @Test
    void testGetAllCardRequest() {
        CardRequest cardRequest1 = new CardRequest(1, "Gold", "Software Engineer", "90000", "Checking", "123456789", "Pending", new User());
        CardRequest cardRequest2 = new CardRequest(2, "Platinum", "Manager", "120000", "Savings", "987654321", "Approved", new User());

        when(cardRequestRepo.findAll()).thenReturn(Arrays.asList(cardRequest1, cardRequest2));

        List<CardRequest> result = cardRequestService.getAllCardRequest();
        assertNotNull(result);
        assertEquals(2, result.size());

        verify(cardRequestRepo, times(1)).findAll();
    }

//    @Test
//    void testUpdateCardRequest() {
//        CardRequest cardRequest = new CardRequest(1, "Gold", "Software Engineer", "90000", "Checking", "123456789", "Pending", new User());
//
//        when(cardRequestRepo.save(cardRequest)).thenReturn(cardRequest);
//
//        cardRequestService.updateCardRequest(cardRequest);
//
//        verify(cardRequestRepo, times(1)).save(cardRequest);
//    }

    @Test
    void testDeleteCardRequest() {
        int cardRequestId = 1;

        cardRequestService.deleteCardrequest(cardRequestId);

        verify(cardRequestRepo, times(1)).deleteById(cardRequestId);
    }

    @Test
    void testGetAllId() {
        List<Integer> ids = Arrays.asList(1, 2, 3);

        when(cardRequestRepo.getIDList()).thenReturn(ids);

        List<Integer> result = cardRequestService.getAllId();
        assertNotNull(result);
        assertEquals(3, result.size());

        verify(cardRequestRepo, times(1)).getIDList();
    }

    @Test
    void testUpdateCardStatus() {
        int cardRequestId = 1;
        String cardStatus = "Approved";
        CardRequest cardRequest = new CardRequest(cardRequestId, "Gold", "Software Engineer", "90000", "Checking", "123456789", cardStatus, new User());

        when(cardRequestRepo.updateCardStatus(cardRequestId, cardStatus)).thenReturn(cardRequest);

        CardRequest result = cardRequestService.updateCardStatus(cardRequestId, cardStatus);
        assertNotNull(result);
        assertEquals(cardStatus, result.getCardStatus());

        verify(cardRequestRepo, times(1)).updateCardStatus(cardRequestId, cardStatus);
    }
}
