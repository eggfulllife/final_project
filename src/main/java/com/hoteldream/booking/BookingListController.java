package com.hoteldream.review;

import com.hoteldream.booking.BookingService;
import com.hoteldream.domain.Booking;
import com.hoteldream.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookingListController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookinglist")
    public String listBookings(Model model) {
        List<Booking> bookings = bookingService.findAll();
        model.addAttribute("bookings", bookings);
        return "bookinglist";
    }

    @GetMapping("/bookinglistcheck")
    public String checkBooking(Model model) {
        List<Booking> bookings = bookingService.findAll();
        model.addAttribute("bookings", bookings);
        return "bookinglistcheck";
    }
}

