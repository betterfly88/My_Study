package com.thejava.di.service;

import com.thejava.di.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    BankRepository bankRepository;
}
