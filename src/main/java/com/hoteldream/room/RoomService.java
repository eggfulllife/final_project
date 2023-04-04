package com.hoteldream.room;

import com.hoteldream.domain.Business;
import com.hoteldream.domain.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
  private final RoomRepository roomRepository;
  private final ModelMapper modelMapper;
  private final Room room;

  /* 객실 목록 조회 */
  public List<Room> getAllRoom(Pageable pageable) {
    List<Room> roomlist = new ArrayList<>();
    roomRepository.findAll(pageable).forEach(room -> roomlist.add(room));

    return roomlist;
  }

  /* 객실 등록 */
  public Room createRoom(RoomForm roomForm) {
    Room room = modelMapper.map(roomForm, Room.class);
    Room newRoom = roomRepository.save(room);

    return newRoom;
  }

  /* 객실 수정 */
  public Room modifyRoom(RoomForm roomForm) {
    modelMapper.map(roomForm, room);
    roomRepository.save(room);

    return room;
  }

  /* 객실 삭제 */
  public void deleteRoom(Long roomId) {
    roomRepository.deleteById(roomId);
  }

  /* 객실 아이디 찾기 */
  public Room getRoomById(Long roomId){
    Room room = roomRepository.findById(roomId).get();

    return room;
  }

}
