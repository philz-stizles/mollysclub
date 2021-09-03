package com.devdezyn.mollysclub.converters.permission;

import com.devdezyn.mollysclub.api.dtos.PermissionDto;
import com.devdezyn.mollysclub.domain.Permission;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PermissionDtoToPermission implements Converter<PermissionDto, Permission> {

  @Nullable
  @Override
  public Permission convert(PermissionDto source) {
    if (source == null) {
      return null;
    }

    final Permission patient = new Permission();

    return patient;
  }
  
}
