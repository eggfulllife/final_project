package com.hoteldream.search;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SearchForm {

    @NotBlank
    private String checkIn;

    @NotBlank
    private String checkOut;

    @NotBlank
    private String price;
}
