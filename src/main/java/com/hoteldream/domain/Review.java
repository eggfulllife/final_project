package com.hoteldream.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Review {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long rev_num;

    @ManyToOne
    @JoinColumn(name = "m_email", referencedColumnName = "email")
    private Member member;

    private Long bo_num;

    @Length(max = 4000)
    private String reviewContent;

    private LocalDate review_date;

    private Integer score;

    @Length(max = 4000)
    private String content_reply;

    private Integer report;
}


