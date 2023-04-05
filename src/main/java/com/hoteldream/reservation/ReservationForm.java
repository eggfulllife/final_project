package com.hoteldream.reservation;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReservationForm {
    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String bu_name;

    @NotBlank
    private String ro_name;

    @NotBlank
    private String checkIn;

    @NotBlank
    private String checkOut;

    @NotBlank
    private String price;
}
