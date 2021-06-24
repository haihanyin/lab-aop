package com.github.hh.labaop.springproxy.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ScannerAuthenticationService implements AuthenticationService {

    public void auth() {
        System.out.println("Authenticate with scanner");
    }
}
