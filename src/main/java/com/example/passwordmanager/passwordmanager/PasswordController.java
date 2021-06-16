package com.example.passwordmanager.passwordmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
// change this mapping to be by id for each request
@RequestMapping(path= "api/v1/user/passwords")
public class PasswordController {

    private final PasswordService passwordService;
    @Autowired
    public PasswordController(PasswordService passwordService){
        this.passwordService = passwordService;

    }

    @GetMapping(path = "api/v1/user/{userId}/passwords")
    public List<Password> getPasswords(){
        return passwordService.getPasswords();
    }

    @PostMapping
    public void createNewPassword(@RequestBody Password password){
        passwordService.addNewPassword(password);
    }

    @DeleteMapping(path = "{passwordId}")
    public void deleteUser(@PathVariable("passwordId") Long passwordId){
        passwordService.deletePassword(passwordId);
    }


    @PutMapping(path = "{passwordId}")
    public void updatePassword(
            @PathVariable("passwordId") Long passwordId,
            @RequestParam(required = true) String websiteName,
            @RequestParam(required = true) char[] sitePassword) {
                passwordService.updatePassword(passwordId,websiteName, sitePassword );
    }


}
