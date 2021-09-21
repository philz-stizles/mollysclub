package com.devdezyn.mollysclub.gymn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.devdezyn.mollysclub.address.Address;
import com.devdezyn.mollysclub.user.User;

import lombok.Data;

@Data
@Entity
public class Gymn {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String logo;
  private Date createdAt;
  private Date updatedAt;
  
  @OneToMany(cascade = CascadeType.ALL)
  private List<Address> addresses = new ArrayList<Address>();

  @OneToOne(cascade = CascadeType.ALL)
  private User account;
}
