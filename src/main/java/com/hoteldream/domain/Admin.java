package com.hoteldream.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Admin {
    @Id @GeneratedValue
    private Integer id;

    private String adminID;

    private String adminPW;
}
