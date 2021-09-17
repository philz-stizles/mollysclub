package com.devdezyn.mollysclub.user;

import java.util.Collection;
import java.util.ArrayList;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.devdezyn.mollysclub.role.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
  @Id
  @SequenceGenerator(
            name = "appuser_sequence",
            sequenceName = "appuser_sequence",
            allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "appuser_sequence"
  )
  private Long id;

  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String telephone;
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  private Collection<Role> roles = new ArrayList<>();
  
  private Boolean locked;
  private Boolean enabled;
  private Boolean credentialExpired;
  private Boolean accountExpired;
}