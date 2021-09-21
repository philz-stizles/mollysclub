package com.devdezyn.mollysclub.location;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // @RequiredArgsConstructor generates a constructor 
// with 1 parameter for each field that requires special handling. All 
// non-initialized final fields get a parameter, as well as any fields that 
// are marked as @NonNull that aren't initialized where they are declared. 
@Service
public class LocationServiceImpl implements LocationService {
  private final LocationRepository appointmentRepository;

  @Override
  public List<LocationDto> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public LocationDto getById(Long ownerId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public LocationDto create(Long creatorId, LocationDto appointmentDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public LocationDto updateByCreator(Long creatorId, Long appointmentId, LocationDto appointmentDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public LocationDto cancel(Long creatorId, Long appointmentId) {
    // TODO Auto-generated method stub
    return null;
  }
}
