package com.nguacon.accountservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Value("${server.port}")
    private String serverPort;
    private static Logger LOG = LoggerFactory.getLogger(AccountController.class);
    @GetMapping
    public ResponseEntity<?> getAccount() {
        LOG.info("Call to server : " + serverPort);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
