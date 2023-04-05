package com.hoteldream.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class RoomValidator implements Validator {

  private final RoomRepository roomRepository;

  @Override
  public boolean supports(Class<?> clazz) {
    return RoomForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    RoomForm roomForm = (RoomForm)target;

    if(roomRepository.existsByRoomTitle(roomForm.getRoomTitle())){
      errors.rejectValue("roomTitle", "invalid.roomTitle", new Object[]{roomForm.getRoomTitle()}, "이미 사용중인 객실 이름입니다. 객실 이름을 바꿔주세요.");
    }

  }
}
