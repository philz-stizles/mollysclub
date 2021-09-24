package com.devdezyn.mollysclub.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

import com.devdezyn.mollysclub.address.Address;
import com.devdezyn.mollysclub.role.Role;
import com.devdezyn.mollysclub.shared.models.BaseEntity;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends BaseEntity {
  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @NotNull
  @Size(max = 40)
  @Column(unique = true)
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

  @Formula("concat(first_name, last_name)")
  private String fullName;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Address> addresses = new ArrayList<Address>();
  
  @Column(columnDefinition = "tinyint(1) default true")
  private Boolean locked;

   @Column(columnDefinition = "tinyint(1) default false")
   private Boolean enabled;
  
  @Column(name = "credential_expired", columnDefinition = "tinyint(1) default false")
  private Boolean credentialExpired;

  @Column(name = "account_expired", columnDefinition = "tinyint(1) default false")
  private Boolean accountExpired;

  @Builder
  public User(Long id, String firstName, String lastName, String username, String name, String email, String telephone, String password, Set<Role> roles, List<Address> addresses, Boolean locked, Boolean enabled, Boolean credentialExpired, Boolean accountExpired) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.name = name;
    this.email = email;
    this.telephone = telephone;
    this.password = password;
    this.roles = roles;
    this.addresses = addresses;
    this.locked = locked;
    this.enabled = enabled;
    this.credentialExpired = credentialExpired;
    this.accountExpired = accountExpired;
  }
}