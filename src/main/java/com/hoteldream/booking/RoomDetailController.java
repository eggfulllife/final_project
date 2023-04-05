package com.hoteldream.booking;

import com.hoteldream.domain.Booking;
import com.hoteldream.domain.Room;
import com.hoteldream.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomDetailController {

  @Autowired
  private final RoomService roomService;
  private final BookingService bookingService;


  @GetMapping("/room-detail/{roomId}")
  public String getRoom(@PathVariable("roomId") Long roomId, Model model) {
    model.addAttribute("room", roomService.getRoomById(roomId));
    return "/room-detail";
  }

  @GetMapping("/rehistory")
  public String search(Model model){
    List<Booking> bookings = bookingService.findAll();
    model.addAttribute("bookings", bookings);

    return "/rehistory";
  }


}
