package com.hoteldream.account;

import com.hoteldream.domain.Business;
import com.hoteldream.domain.Member;
import com.hoteldream.domain.Room;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
//@Component
public class MemberService {

    private final MemberRepository memberRepository;

    private final BusinessRepository businessRepository;

    private final ModelMapper modelMapper;

    private final Room room;

    public Member getMemberOne(String email){
        Member exist = memberRepository.findByEmail(email);
        return exist;
    }

    public Business getBusinessOne(String bu_email){
        Business exist = businessRepository.findByBuEmail(bu_email);
        return exist;
    }


    public Member createNewMember(MeSignUpForm meSignUpForm){
        Member member = Member.builder()
          .email(meSignUpForm.getEmail())
          .password(meSignUpForm.getPassword())
          .name(meSignUpForm.getName())
          .phoneNumber(meSignUpForm.getPhoneNumber())
          .build();

        return memberRepository.save(member);
    }

    public Business createNewBusiness(BuSignUpForm buSignupForm){
        Business business = Business.builder()
          .buEmail(buSignupForm.getEmail())
          .buPassword(buSignupForm.getPassword())
          .buName(buSignupForm.getName())
          .buTitle(buSignupForm.getBuName())
          .buAddress(buSignupForm.getBuAddress())
          .hotelPhoto(buSignupForm.getHotelPhoto())
          .build();
        return businessRepository.save(business);
    }


    public void login(Member member){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
          new MemberAccount(member),
          member.getPassword(),
          List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(token);
    }

    public void buLogin(Business business){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
          new BusinessAccount(business),
          business.getBuPassword(),
          List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(token);
    }

    // public int businessTelCount(){
    //  return (int)memberRepository.count();
    //}

    /*
    // 문자인증 코드 전송
    public String sendRandomMessage(String tel) {
        Naver_Sens_V2 message = new Naver_Sens_V2();
        Random rand = new Random();
        String numStr = "";
        for (int i = 0; i < 6; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr += ran;
        }
        System.out.println("회원가입 문자 인증 => " + numStr);

//		message.send_msg(tel, numStr);

        return numStr;
    }

     */

}













