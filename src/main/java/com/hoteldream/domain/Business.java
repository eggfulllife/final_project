package com.hoteldream.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @EqualsAndHashCode(of = "id")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Business implements Serializable {
    @Id @GeneratedValue
    private Long id;

    //@OneToMany(mappedBy = "business")
    private String buEmail;

    private String buPassword, buTel, buName, buAddress;

    private String buTitle;

    @OneToMany(mappedBy = "buTitle")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "buEmail")
    private List<Room> rooms = new ArrayList<>();

    private String hotelPhoto;

    private String location;
    private String minPrice, picLocation;
}
