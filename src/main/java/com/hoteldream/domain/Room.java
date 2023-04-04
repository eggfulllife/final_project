package com.hoteldream.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(of="roomId")
@Builder @AllArgsConstructor @NoArgsConstructor
@Component
public class Room implements Serializable {
    @Id
    @GeneratedValue
    private Long roomId;

    @OneToMany(mappedBy = "ro_id")
    private List<Booking> rooms = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "buEmail", referencedColumnName = "buEmail")
    private Business buEmail;

    @Column(unique = true)
    private String roomTitle;

    private Integer roomPrice;

    private LocalTime checkIn;

    private LocalTime checkOut;

    private String guest;

    @Length(max = 4000)
    private String roomInfo;

    private String roomPhoto;
}
