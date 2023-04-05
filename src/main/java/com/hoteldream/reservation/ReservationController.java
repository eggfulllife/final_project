package com.hoteldream.reservation;

import com.hoteldream.account.MemberRepository;
import com.hoteldream.account.MemberService;
import com.hoteldream.booking.BookingRepository;
import com.hoteldream.booking.BookingService;
import com.hoteldream.domain.Booking;
import com.hoteldream.domain.Member;
import com.hoteldream.room.RoomService;
import com.hoteldream.search.SearchForm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/reservation/")
@RequiredArgsConstructor
public class ReservationController {
    Model model;

    private final MemberService memberService;
    private final ReservationService reservationService;
    private final RoomService roomService;
    private final BookingService bookingService;

    @GetMapping("reservationForm")
    public String search(ReservationForm reservationForm) {
        model.addAttribute("searchForm", new SearchForm());
        return "";
    }

    @PostMapping("reservationForm")
    public String searchSubmit(@Valid ReservationForm reservationForm, Errors errors){
        if(errors.hasErrors()){
            return "";
        }

        Booking reservation = reservationService.createNewReservation(reservationForm);

        model.addAttribute("reservation", reservation);
        return "search/search";
    }

    @GetMapping("/reserve/{roomId}")
    public String reserve(@PathVariable("roomId") Long bu_num, Model model){
//        String email = (String) session.getAttribute("email");
//        Member m = null;
//        try {
//            m = memberService.getMemberOne(email);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        int night = DateParse.dateDif(booking.getCheckin(), booking.getCheckout()); // (checkout-checkin)
//        booking.setPrice((Integer.parseInt(booking.getPrice()) * night)+"");
//        booking.setEmail(email);

//        session.setAttribute("booking", booking);
//        model.addAttribute("member", m);
//        model.addAttribute("room", roomService.getRoomById(roomId));
        model.addAttribute("booking", bookingService.getById(bu_num));

        return "reserve";
    }
}
