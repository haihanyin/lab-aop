package com.github.hh.labaop.springproxy.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScannerAuthenticationServiceTest {

    @Autowired
    private AuthenticationService authenticationService;

    @Test
    public void test() {
        if (authenticationService.getClass() == ScannerAuthenticationService.class) {
            System.out.println("classes are equal");
        }
        if (authenticationService instanceof ScannerAuthenticationService) {
            System.out.println("is instance of");
        }
        authenticationService.auth();
        System.out.println(authenticationService.getClass());
    }
}