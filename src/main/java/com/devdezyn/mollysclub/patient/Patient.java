package com.devdezyn.mollysclub.patient;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.devdezyn.mollysclub.auth.AppUser;

@Entity
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String address;

  @OneToOne(cascade = CascadeType.ALL)
  private AppUser account;
}
