package com.devdezyn.mollysclub.gymn;

import java.util.List;

public interface GymnService {
  List<GymnDto> getAll();

  GymnDto getById(Long gymnId);
  GymnDto getById(Long gymnId, Long ownerId);
  GymnDto create(Long creatorId, GymnDto gymnDto);

  GymnDto updateByCreator(Long creatorId, Long appointmentId, GymnDto gymnDto);
  GymnDto archiveByCreator(Long creatorId, Long appointmentId);
}
