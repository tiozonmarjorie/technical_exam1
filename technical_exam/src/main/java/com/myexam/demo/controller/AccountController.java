package com.myexam.demo.controller;

import com.myexam.demo.AccountRepository;
import com.myexam.demo.CustomException;
import com.myexam.demo.ResourceNotFoundException;
import com.myexam.demo.ResponseMessage;
import com.myexam.demo.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/api/v1/account")
    public ResponseEntity<ResponseMessage> newAccount(@RequestBody Account newAccount) {

        if (newAccount.getCustomerEmail() != null) {
            accountRepository.save(newAccount);
            ResponseMessage responseMessage = new ResponseMessage(newAccount.getCustomer_Id().intValue(),
                    HttpStatus.CREATED.value(),
                    "Customer account created");
            return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
        }else {
             throw new CustomException("Email is required field");
        }

    }

    @GetMapping("/api/v1/account/{id}")
    public ResponseEntity<Account> findAccount(@PathVariable("id") long id){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        ResponseMessage responseMessage = new ResponseMessage(account.getCustomer_Id().intValue(),
                HttpStatus.FOUND.value(),"Customer Account found");
        account.setResponseMessage(responseMessage);
        return new ResponseEntity<>(account, HttpStatus.FOUND);
    }


}
