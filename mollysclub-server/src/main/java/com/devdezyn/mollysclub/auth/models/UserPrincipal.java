package com.devdezyn.mollysclub.auth.models;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.ArrayList;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.devdezyn.mollysclub.user.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal implements UserDetails {
  private Long id;

  private String name;
  private String username;
  private String email;
  private String password;
  
  private Collection<? extends GrantedAuthority> authorities;

  public static UserPrincipal create(User user) {
    // Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    // user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

      List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
              new SimpleGrantedAuthority(role.getName())
              ).collect(Collectors.toList());
      
      return new UserPrincipal(
              user.getId(),
              user.getName(),
              user.getUsername(),
              user.getEmail(),
              user.getPassword(),
              authorities
      );
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}