package com.hoteldream.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Search {
    @Id @GeneratedValue
    private int id;
    private String bu_address;
    private String checkin;
    private String checkout;
    private String ro_count;
    private String bu_id;
    private String lowprice;
    private String highprice;
}
