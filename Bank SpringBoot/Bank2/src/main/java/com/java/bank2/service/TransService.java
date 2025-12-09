package com.java.bank2.service;

import com.java.bank2.model.Trans;
import com.java.bank2.repo.TransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransService {

    @Autowired
    private TransRepository transRepository;

    public void addHistory(Trans trans){
        transRepository.save(trans);
    }
}
