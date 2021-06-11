package com.example.passwordmanager.passwordmanager;

import javax.persistence.*;

@Entity
@Table(name = "userpasswords")
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

    private Long passwordId;
    private String siteName;
    private String siteUsername;
    private char[] sitePassword;

    public Password() {
    }

    public Long getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(Long passwordId) {
        this.passwordId = passwordId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteUrl) {
        this.siteName = siteUrl;
    }

    public String getSiteUsername() {
        return siteUsername;
    }

    public void setSiteUsername(String siteUsername) {
        this.siteUsername = siteUsername;
    }

    public char[] getSitePassword() {
        return sitePassword;
    }

    public void setSitePassword(char[] sitePassword) {
        this.sitePassword = sitePassword;
    }
}
