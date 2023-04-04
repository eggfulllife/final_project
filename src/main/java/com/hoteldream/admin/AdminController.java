package com.hoteldream.admin;

import com.hoteldream.domain.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class AdminController {

    private final AdminService adminService;

    private final Admin admin;

    @GetMapping("/adminlogin")
    public String signUpForm(Model model) {
        model.addAttribute(new AdminForm());
        return "/adminlogin";
    }

    @PostMapping("/adminlogin")
    public String newAdminSubmit(AdminForm adminForm, Model model) throws IOException {

        List<Admin> adminList = adminService.adminAccountReader();

        for (int i = 0; i < adminList.size(); i++) {
            if (adminForm.getAdminID().equals(adminList.get(i).getAdminID()) && adminForm.getAdminPW().equals(adminList.get(i).getAdminPW())) {
                return "redirect:/reviewcontrol";
            }
        }

        return "redirect:/adminlogin";
    }
}

