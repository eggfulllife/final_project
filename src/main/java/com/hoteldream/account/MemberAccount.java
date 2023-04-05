package com.hoteldream.account;

import com.hoteldream.domain.Member;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;
@Getter
public class MemberAccount extends User{

    private Member member;
    public MemberAccount(Member member){
          super(member.getEmail(),
                member.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
                this.member = member;
    }
}
