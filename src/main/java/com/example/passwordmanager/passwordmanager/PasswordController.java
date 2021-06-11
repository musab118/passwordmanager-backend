package com.example.passwordmanager.passwordmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user/{id}/passwords")
public class PasswordController {
    private final PasswordService passwordService;
    @Autowired
    public PasswordController (PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping
    public List<Password> getPasswords(){return passwordService.getPassword();}

    @PostMapping
    public void createPassword(@RequestBody Password password){passwordService.createPassword(password)}
}
