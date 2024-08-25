//package com.supraja.restapp.serviceimpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.supraja.restapp.model.Creditcard;
//import com.supraja.restapp.model.User;
//import com.supraja.restapp.repository.CreditcardRepo;
//
//public class CreditcardServiceImplTest {
//
//    @Mock
//    private CreditcardRepo creditcardRepo;
//
//    @InjectMocks
//    private CreditcardServiceImpl creditcardService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
////    @Test
////    void testAddCreditcard() {
////        Creditcard creditcard = new Creditcard(1, "John Doe", "1234567890123456", "12/24", "123", new User());
////
////        when(creditcardRepo.save(creditcard)).thenReturn(creditcard);
////
////        String result = creditcardService.addCreditcard(creditcard);
////        assertEquals("AddSuccess", result);
////
////        verify(creditcardRepo, times(1)).save(creditcard);
////    }
//
////    @Test
////    void testGetCreditcard() {
////        Creditcard creditcard = new Creditcard(1, "John Doe", "1234567890123456", "12/24", "123", new User());
////
////        when(creditcardRepo.findById(1)).thenReturn(Optional.of(creditcard));
////
////        Creditcard result = creditcardService.getCreditcard(1);
////        assertNotNull(result);
////        assertEquals(1, result.getCardid());
////        assertEquals("John Doe", result.getCardholderName());
////
////        verify(creditcardRepo, times(1)).findById(1);
////    }
//
//    @Test
//    void testGetAllCreditcards() {
//        Creditcard creditcard1 = new Creditcard(1, "John Doe", "1234567890123456", "12/24", "123", new User());
//        Creditcard creditcard2 = new Creditcard(2, "Jane Doe", "6543210987654321", "11/25", "456", new User());
//
//        when(creditcardRepo.findAll()).thenReturn(Arrays.asList(creditcard1, creditcard2));
//
//        List<Creditcard> result = creditcardService.getAllCreditcard();
//        assertNotNull(result);
//        assertEquals(2, result.size());
//
//        verify(creditcardRepo, times(1)).findAll();
//    }
//
////    @Test
////    void testUpdateCreditcard() {
////        Creditcard creditcard = new Creditcard(1, "John Doe", "1234567890123456", "12/24", "123", new User());
////
////        when(creditcardRepo.save(creditcard)).thenReturn(creditcard);
////
////        creditcardService.updateCreditcard(creditcard);
////
////        verify(creditcardRepo, times(1)).save(creditcard);
////    }
//
//    @Test
//    void testDeleteCreditcard() {
//        int cardId = 1;
//
//        creditcardService.deleteCreditcard(cardId);
//
//        verify(creditcardRepo, times(1)).deleteById(cardId);
//    }
//
//    @Test
//    void testGetCreditcardByUserId() {
//        User user = new User(); // Assuming User class has a default constructor
//        Creditcard creditcard = new Creditcard(1, "John Doe", "1234567890123456", "12/24", "123", user);
//
//        when(creditcardRepo.findByUserId(user.getId())).thenReturn(creditcard);
//
//        Creditcard result = creditcardService.getCreditcardByUserId(user.getId());
//        assertNotNull(result);
//        assertEquals(1, result.getCardid());
//        assertEquals(user, result.getUser());
//
//        verify(creditcardRepo, times(1)).findByUserId(user.getId());
//    }
//}
