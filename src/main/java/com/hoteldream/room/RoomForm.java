package com.hoteldream.room;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Data
@Component
public class RoomForm {
  private Long roomId;

  private String roomTitle;

  private Integer roomPrice;

  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private LocalTime checkIn;

  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private LocalTime checkOut;

  private String guest;

  @Length(max = 4000)
  private String roomInfo;

  private String roomPhoto;
}
