package com.paypal.demo.controller;

import com.paypal.demo.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createTransaction_ValidData_ReturnsCreatedTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId("123");
        transaction.setAmount(100.0);

        ResponseEntity<Transaction> response = restTemplate.postForEntity("/api/transactions", transaction, Transaction.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void createTransaction_InvalidData_ReturnsBadRequest() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(null);
        transaction.setAmount(-100.0);

        ResponseEntity<String> response = restTemplate.postForEntity("/api/transactions", transaction, String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void getTransactions_EmptyList_ReturnsOk() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/transactions", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
