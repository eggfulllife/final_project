package com.hoteldream.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Setter @Getter
public class BookingStatus implements Serializable {
    @Id @GeneratedValue
    private Long id;

    private int status;
}
