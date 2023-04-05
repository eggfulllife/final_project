package com.hoteldream.account;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class BuSignUpForm {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @Length(min=3, max=20)
    @Pattern(regexp="^[ㄱ-ㅎ가-힣-a-zA-Z0-9]{3,20}$")
    private String name;

    @NotBlank
    @Length(min=3, max=20)
    @Pattern(regexp="^[ㄱ-ㅎ가-힣-a-zA-Z0-9]{3,20}$")
    private String buName;

    @NotBlank
    @Length(min=3, max=50)
    //@Pattern(regexp="^[ㄱ-ㅎ가-힣-a-zA-Z0-9]{3,50}$")
    private String buAddress;

    @NotBlank
    private String hotelPhoto;

}
