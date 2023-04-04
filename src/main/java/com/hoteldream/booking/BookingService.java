package com.hoteldream.booking;

import com.hoteldream.domain.Booking;
import com.hoteldream.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    public void deleteById(Long bo_num) {
        bookingRepository.deleteById(bo_num);
    }

    public Optional<Booking> findById(Long bo_num) {
        return bookingRepository.findById(bo_num);
    }

    public Booking getById(Long bo_num) {
        Booking booking = bookingRepository.findById(bo_num).get();

        return booking;
    }

}

