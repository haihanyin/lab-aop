package com.github.hh.labaop.springproxy.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScannerAuthenticationServiceTest {

    @Autowired
    private AuthenticationService scannerAuthenticationService;

    @Test
    public void test() {
        if (scannerAuthenticationService.getClass() == ScannerAuthenticationService.class) {
            System.out.println("classes are equal");
        }
        if (scannerAuthenticationService instanceof ScannerAuthenticationService) {
            System.out.println("is instance of");
        }
        scannerAuthenticationService.auth();
        System.out.println(scannerAuthenticationService.getClass());
    }
}