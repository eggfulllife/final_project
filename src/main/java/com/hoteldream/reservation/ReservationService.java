package com.hoteldream.reservation;

import com.hoteldream.domain.Booking;
import com.hoteldream.domain.Room;
import com.hoteldream.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {
    ModelMapper modelMapper;

    @Autowired
    RoomRepository roomRepository;

    private final Booking booking;

    final Booking createNewReservation(ReservationForm reservationForm){
        Booking newReservation = modelMapper.map(reservationForm, Booking.class);
        return newReservation;
    }

    // 객실 번호로 조회
    public Room getRoom(Long roomId) throws Exception {
        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        if (optionalRoom.isPresent()) {
            return optionalRoom.get();
        }
        throw new Exception("Room not found with id: " + roomId);
    }


}
