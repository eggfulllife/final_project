package com.hoteldream.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter @Setter
@Component
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bo_num;

    @ManyToOne
    @JoinColumn(name = "m_email", referencedColumnName = "email")
    private Member email;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room ro_id;

    @ManyToOne
    @JoinColumn(name="buTitle", referencedColumnName = "buTitle")
    private Business buTitle;

    private String guest;

    private String ro_name;

    private String checkin;

    private String phoneNumber;

    private String checkout;

    private Integer status;

    private String price;

    private String reg_date;

    private String name;
}
