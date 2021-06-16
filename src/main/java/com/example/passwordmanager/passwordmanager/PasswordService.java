package com.example.passwordmanager.passwordmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PasswordService {
    private final PasswordRepository passwordRepository;

    @Autowired
    public PasswordService(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }


    public List<Password> getPasswords() {
        return passwordRepository.findAll();
    }

    //    Add new password to DB
    public void addNewPassword(Password password) {
        Optional<Password> passwordOptional = passwordRepository.findPasswordBySite(password.getWebsite());
//        Add more validation here
        if (passwordOptional.isPresent()) {
            throw new IllegalStateException("Passwod for: " + password.getWebsite() + "is already available");
        } else {
            passwordRepository.save(password);
        }
    }


//    Delete password

    public void deletePassword(Long passwordId) {
        boolean passwordExists = passwordRepository.existsById(passwordId);
        if (!passwordExists) {
            throw new IllegalStateException("Password does not exist");
        } else {
            passwordRepository.deleteById(passwordId);
        }
    }


//    Update password

    public void updatePassword(Long passwordId, String websiteName, char[] userPassword) {
        Password password = passwordRepository.findById(passwordId).orElseThrow(() -> new IllegalStateException("Password for website : " + websiteName + "does not exist "));

        if (websiteName != null && websiteName.length() > 0 && !Objects.equals(password.getWebsite(), websiteName)) {
            password.setWebsite(websiteName);
        }


        if (userPassword != null && userPassword.length > 0 && Arrays.equals(password.getPassword(), userPassword)) {
            Optional<Password> passwordOptional = passwordRepository.findPasswordBySite(websiteName);
            password.setPassword(userPassword);

        }


    }


}


