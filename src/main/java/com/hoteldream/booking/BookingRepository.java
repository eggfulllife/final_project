package com.hoteldream.booking;

import com.hoteldream.domain.Booking;
import com.hoteldream.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

  Booking findByCheckin(String checkin);
}
