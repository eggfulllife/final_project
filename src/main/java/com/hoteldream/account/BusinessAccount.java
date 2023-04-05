package com.hoteldream.account;

import com.hoteldream.domain.Business;
import com.hoteldream.domain.Member;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class BusinessAccount extends User {
    private Business business;
    public BusinessAccount(Business business){
          super(business.getBuEmail(),
                business.getBuPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.business = business;
    }
}
