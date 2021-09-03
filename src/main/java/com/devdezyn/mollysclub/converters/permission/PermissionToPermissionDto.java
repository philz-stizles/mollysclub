package com.devdezyn.mollysclub.converters.permission;

import com.devdezyn.mollysclub.api.dtos.PermissionDto;
import com.devdezyn.mollysclub.domain.Permission;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PermissionToPermissionDto implements Converter<Permission, PermissionDto> {

  @Nullable
  @Override
  public PermissionDto convert(Permission source) {
    if (source == null) {
      return null;
    }

    final PermissionDto patientDto = new PermissionDto();

    return patientDto;
  }
  
}
