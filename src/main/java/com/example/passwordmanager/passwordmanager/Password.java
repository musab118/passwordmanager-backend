package com.example.passwordmanager.passwordmanager;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name = "storedpasaswords")
public class Password {


    @Id
    @SequenceGenerator(
            name = "password_sequence",
            sequenceName = "password_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "password_sequence"
    )



    private Long password_id;
    private String website;
    private char[] password;

    public Password() {
    }

    public Password(Long password_id) {
        this.password_id = password_id;
    }

    public Password(Long password_id, String website, char[] password) {
        this.password_id = password_id;
        this.website = website;
        this.password = password;
    }

    public Long getPassword_id() {
        return password_id;
    }

    public void setPassword_id(Long password_id) {
        this.password_id = password_id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
