package com.devdezyn.mollysclub.auth.dtos;

import java.util.Set;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoggedInRole {
  private String name;
  private Set<String> permissions;
}
