package com.example.passwordmanager.passwordmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {
    private final PasswordRepository passwordRepository;
    @Autowired
    public PasswordService(PasswordRepository passwordRepository){
        this.passwordRepository = passwordRepository;
    }


}
