package com.hoteldream.account;

import com.hoteldream.domain.Business;
import com.hoteldream.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class MemberController {
    HttpServletRequest request;
    HttpSession session;

    private final MemberService memberService;
    // private final ReviewService reviewService;
    private final PasswordEncoder passEnc;

    private final MemberRepository memberRepository;

    private final BusinessRepository businessRepository;


    @GetMapping("/member/meSignUpForm")
    public String meSignUpForm(Model model) {
        model.addAttribute("meSignUpForm", new MeSignUpForm());
        return "member/meSignUpForm";
    }

    @PostMapping("/member/meSignUpForm")
    public String meSignUpForm(@Valid MeSignUpForm meSignUpForm, Errors errors) {
        if(errors.hasErrors()){
            // 에러가 발생하면 다음 페이지로 넘어가지 않고
            // 다시 sign-up 페이지를 보여줌
            return "/member/meSignUpForm";
        }
        Member newMember = memberService.createNewMember(meSignUpForm);
        memberService.login(newMember);
        return "redirect:/";
    }

    @GetMapping("/member/buSignUpForm")
    public String buSignUpForm(Model model) {
        model.addAttribute("buSignUpForm", new BuSignUpForm());
        return "member/buSignUpForm";
    }

    @PostMapping("/member/buSignUpForm")
    public String buSignUpForm(@Valid BuSignUpForm buSignupForm, Errors errors) {
        if(errors.hasErrors()){
            // 에러가 발생하면 다음 페이지로 넘어가지 않고
            // 다시 sign-up 페이지를 보여줌
            return "/member/buSignUpForm";
        }
        Business newBusiness = memberService.createNewBusiness(buSignupForm);
        memberService.buLogin(newBusiness);
        return "redirect:/";
    }

    @RequestMapping("logout")
    public String logout(Model model) {
        session.invalidate();
        model.addAttribute("msg", "로그아웃 하였습니다.");
        return "redirect:/search/main";
    }


    @GetMapping ("/member/loginForm")
    public String loginForm(String email, Model model) {
        Member member = memberRepository.findByEmail(email);
        if(member == null){
            model.addAttribute("error", "로그인할 수 없습니다.");
            return "/member/loginForm";
        }
        memberService.login(member);
        return "redirect:/";
    }

    @GetMapping("/member/buLoginForm")
    public String buLoginForm(String email, Model model) {
        Business business = businessRepository.findByBuEmail(email);
        if(business == null){
            model.addAttribute("error", "로그인할 수 없습니다.");
            return "/member/buLoginForm";
        }
        memberService.buLogin(business);
        return "redirect:/roomlist";
    }

}
