package com.devdezyn.mollysclub.user;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

import com.devdezyn.mollysclub.address.Address;
import com.devdezyn.mollysclub.db_docs.DBFile;
import com.devdezyn.mollysclub.role.Role;
import com.devdezyn.mollysclub.shared.models.DateAudit;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    
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
  private Set<Role> roles;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Address> addresses;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private DBFile  avatar;
  
  @Column(columnDefinition = "tinyint(1) default true")
  private Boolean locked;

  @Column(columnDefinition = "tinyint(1) default false")
  private Boolean enabled;
  
  @Column(name = "credential_expired", columnDefinition = "tinyint(1) default false")
  private Boolean credentialExpired;

  @Column(name = "account_expired", columnDefinition = "tinyint(1) default false")
  private Boolean accountExpired;
}