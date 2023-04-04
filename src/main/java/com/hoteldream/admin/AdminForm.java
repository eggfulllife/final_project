package com.hoteldream.admin;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Component
@Getter
@Setter

public class AdminForm {
    private String adminID;


    private String adminPW;


}

