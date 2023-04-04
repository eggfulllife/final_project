package com.hoteldream.account;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class MeSignUpForm {
    @NotBlank
    @Email
    private String Email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;
}
