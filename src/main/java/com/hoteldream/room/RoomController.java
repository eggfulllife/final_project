package com.hoteldream.room;

import com.hoteldream.account.MemberService;
import com.hoteldream.domain.Business;
import com.hoteldream.domain.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class RoomController {

  private final RoomService roomService;
  private final Room room;
  private final RoomValidator roomValidator;

  @InitBinder("roomForm")
  public void initBinder(WebDataBinder webDataBinder) {
    webDataBinder.addValidators(roomValidator);
  }


  /* 비즈니스 로그인 화면 - 객실 목록 조회 */
  @GetMapping("/roomlist")
  public String roomlist(Room room, Model model,
                         @PageableDefault(sort = "roomId") Pageable pageable){
    model.addAttribute("roomlist", roomService.getAllRoom(pageable));

    return "room/roomlist";
  }


  /**/
  @GetMapping("/roominfo")
  public String roominfo(Room room, Model model,
                         @PageableDefault(sort = "roomId") Pageable pageable) {
    model.addAttribute("roomlist", roomService.getAllRoom(pageable));

    return "roominfo";
  }


  /* 객실 등록 */
  @GetMapping("/new-room")
  public String newRoom(Model model){
    model.addAttribute(new RoomForm());

    return "/room/new-room";
  }

  @PostMapping("/new-room")
  public String newRoomSubmit(@Valid RoomForm roomForm, Errors errors, Model model){

    if(errors.hasErrors()) {
      model.addAttribute(room);
      return "/room/new-room";
    }
    Room room = roomService.createRoom(roomForm);

    return "redirect:/roomlist";
  }

  /* 객실 정보 조회 */
  @GetMapping("/businessroominfo/{roomId}")
  public String showBusinessRoom(@PathVariable("roomId") Long roomId, Model model){
    model.addAttribute("room", roomService.getRoomById(roomId));

    return "/room/businessroominfo";
  }


  /* 객실 수정 */
  @GetMapping("/modify-room/{roomId}")
  public String modifyRoom(@PathVariable("roomId") Long roomId, Model model){
    model.addAttribute("room", roomService.getRoomById(roomId));

    return "/room/modify-room";
  }

  @PostMapping("/modify-room/{roomId}")
  public String modifyRoomSubmit(RoomForm roomForm){
    roomService.modifyRoom(roomForm);

    return "redirect:/roomlist";
  }


  /* 객실 삭제 */
  @GetMapping("/delete-room/{roomId}")
  public String deleteRoom(@PathVariable("roomId") Long roomId){
    roomService.deleteRoom(roomId);

    return "redirect:/roomlist";
  }


}