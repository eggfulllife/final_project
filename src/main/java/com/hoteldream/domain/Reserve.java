package com.hoteldream.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Reserve {
    @Id @GeneratedValue
    private int id;
    private int ro_num;
    private String re_date;
}
