package com.devdezyn.mollysclub.location;

import java.util.Date;

import lombok.Data;

@Data
public class LocationDto {
  private Long id;
  private Long longitude;
  private Long latitude;
  private Date createdAt;
  private Date updatedAt;
}
