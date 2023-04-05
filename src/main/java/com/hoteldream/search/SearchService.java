package com.hoteldream.search;

import com.hoteldream.account.BusinessRepository;
import com.hoteldream.booking.BookingRepository;
import com.hoteldream.domain.Booking;
import com.hoteldream.domain.Business;
import com.hoteldream.domain.Room;
import com.hoteldream.domain.Search;
import com.hoteldream.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchService {
    private final BookingRepository bookingRepository;

    private final BusinessRepository businessRepository;

    private final ModelMapper modelMapper;

    public List<Business> createNewSearchBu(SearchForm searchform){
        Booking Search = modelMapper.map(searchform, Booking.class);
        List<Business> businesses = searchBusinessList(Search);
        return businesses;
    }

     public List<Booking> createNewSearchBo(SearchForm searchform){
         Booking Search = modelMapper.map(searchform, Booking.class);
         List<Booking> bookings = searchBookingList(Search);
         return bookings;                                                 
     }




    // booking 으로 안되면 business 넣고 확인하기
    private List<Business> searchBusinessList(Booking search) {

        String newSearch = search.getCheckin();
        List<Business> businessList = new ArrayList<>();
        if(bookingRepository.findByCheckin(newSearch) == null){
           businessRepository.findAll().forEach(business -> businessList.add(business));
        }else{
            searchBookingList(search);
        }
        return businessList;
    }

    private List<Booking>searchBookingList(Booking search) {
        List<Booking> bookingList = new ArrayList<>();
        String newSearch = search.getCheckin();
        Booking booking = null;
        while(booking != null) {
            booking = bookingRepository.findByCheckin(newSearch);
            bookingList.add(booking);
        }
        return bookingList;
    }


}
