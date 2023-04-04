package com.hoteldream.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ReviewForm {
    private Long rev_num;


    private String email;  // 성구 : m_email;

    private Long bo_num;

    @Length(max = 4000)
    private String reviewContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate review_date;

    private String score;

    @Length(max = 4000)
    private String content_reply;

    private Integer report;


}