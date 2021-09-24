package com.devdezyn.mollysclub.permission;

import java.util.List;
import java.util.Set;

public interface  PermissionService {

    List<PermissionDto> getPermissions();

    Set<PermissionDto> getPermissionDtosByIds(Set<Long> ids);

    List<Permission> getPermissionsByIds(Set<Long> ids);
}
