package com.devdezyn.mollysclub.doctor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.devdezyn.mollysclub.address.Address;
import com.devdezyn.mollysclub.auth.AppUser;

import lombok.Data;

@Data
@Entity
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  
  private String specialization;
  private String mobile;
  private String gender;
  private Integer age;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Address> addresses = new ArrayList<Address>();

  @OneToOne(cascade = CascadeType.ALL)
  private AppUser account;
}
