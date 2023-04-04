package com.hoteldream.search;


import com.hoteldream.domain.Booking;
import com.hoteldream.domain.Business;
import com.hoteldream.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class SearchController {
    HttpServletRequest request;
    HttpSession session;

    private final SearchService searchService;
    private final RoomService roomService;

    @GetMapping ("/search/searchForm")
    public String searchForm(Model model) {
        model.addAttribute("searchForm", new SearchForm());
        return "search/searchForm";
    }
    @PostMapping("/search/searchForm")
    public String searchForm(@Valid SearchForm searchForm, Errors errors, Model model, @PageableDefault(sort = "roomId") Pageable pageable){
        if(errors.hasErrors()) {
            return "errorPage?";
        }
        model.addAttribute("roomlist", roomService.getAllRoom(pageable));
        List<Business> businessList = searchService.createNewSearchBu(searchForm);
        if(businessList == null){
            List<Booking> bookingList = searchService.createNewSearchBo(searchForm);
            model.addAttribute("bookingList", bookingList);
            return "/search/searchFormBo";
        }else{
            model.addAttribute("businessList", businessList);
        }
        return "/search/searchFormBu";
    }


}
