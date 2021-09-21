package com.devdezyn.mollysclub.gymn;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // @RequiredArgsConstructor generates a constructor 
// with 1 parameter for each field that requires special handling. All 
// non-initialized final fields get a parameter, as well as any fields that 
// are marked as @NonNull that aren't initialized where they are declared. 
@Service
public class GymnServiceImpl implements GymnService {
  private final GymnRepository gymnRepository;

  @Override
  public List<GymnDto> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GymnDto getById(Long gymnId) {
    // TODO Auto-generated method stub
    return null;
  }

 @Override
  public GymnDto getById(Long gymnId, Long ownerId) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public GymnDto create(Long creatorId, GymnDto gymnDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GymnDto updateByCreator(Long creatorId, Long gymnId, GymnDto gymnDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GymnDto archiveByCreator(Long gymnId, Long creatorId) {
    // TODO Auto-generated method stub
    return null;
  }
}
