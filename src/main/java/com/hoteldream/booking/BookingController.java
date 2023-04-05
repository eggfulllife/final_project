package com.hoteldream.booking;

import com.hoteldream.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/form")
    public String form(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "form";
    }

    @RequestMapping(value = "/booking/delete/{bo_num}", method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
    public String deleteBooking(@PathVariable Long bo_num) {
        bookingService.deleteById(bo_num);
        return "redirect:/bookinglist";
    }
}