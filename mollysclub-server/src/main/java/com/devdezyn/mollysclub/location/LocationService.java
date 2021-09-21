package com.devdezyn.mollysclub.location;

import java.util.List;

public interface LocationService {
  List<LocationDto> getAll();
  LocationDto getById(Long ownerId);
  LocationDto create(Long creatorId, LocationDto addressDTO);

  LocationDto updateByCreator(Long creatorId, Long appointmentId, LocationDto addressDTO);
  LocationDto cancel(Long creatorId, Long appointmentId);
}
