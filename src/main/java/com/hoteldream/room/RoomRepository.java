package com.hoteldream.room;

import com.hoteldream.domain.Business;
import com.hoteldream.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface RoomRepository extends JpaRepository<Room, Long> {

  @Override
  List<Room> findAllById(Iterable<Long> roomId);

  boolean existsByRoomTitle(String roomTitle);
}
