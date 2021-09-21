package com.devdezyn.mollysclub.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.devdezyn.mollysclub.role.Role;
import com.devdezyn.mollysclub.shared.models.DateAudit;

import org.hibernate.annotations.NaturalId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit {
  @Id
  @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "user_sequence"
  )
  private Long id;

  private String firstName;
  private String lastName;

  @Size(max = 40)
  private String username;
  private String name;

  @NaturalId
  @NotBlank
  @Size(max = 40)
  @Email
  private String email;

  private String telephone;

  @NotBlank
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();
  
  private Boolean locked;
  private Boolean enabled;
  private Boolean credentialExpired;
  private Boolean accountExpired;

  public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
  }
}