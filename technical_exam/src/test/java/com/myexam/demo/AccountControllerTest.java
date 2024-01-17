package com.myexam.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.myexam.demo.controller.AccountController;
import com.myexam.demo.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AccountControllerTest {

    @Test
    public void testNewAccountSuccess() {

        AccountRepository mockRepository = mock(AccountRepository.class);
        AccountController accountController = new AccountController(mockRepository);
        Account newAccount = new Account();
        newAccount.setCustomer_Id(1L);
        newAccount.setCustomerEmail("email@example.com");

        ResponseEntity<ResponseMessage> response = accountController.newAccount(newAccount);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Customer account created", response.getBody().getTransactionStatusDescription());

        verify(mockRepository, times(1)).save(newAccount);
    }

    @Test
    public void testNewAccountFailure() {

        AccountRepository mockRepository = mock(AccountRepository.class);
        AccountController accountController = new AccountController(mockRepository);
        Account newAccount = new Account();


        CustomException exception = assertThrows(CustomException.class, () -> {
            accountController.newAccount(newAccount);
        });

        assertEquals("Email is required field", exception.getMessage());
        verify(mockRepository, never()).save(newAccount);
    }
}
