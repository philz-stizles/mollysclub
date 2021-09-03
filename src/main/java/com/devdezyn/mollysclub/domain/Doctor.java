package com.devdezyn.mollysclub.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String specialization;
  private String mobile;
  private String gender;
  private Integer age;

  // @OneToMany(cascade = CascadeType.ALL)
  // private List<Address> addresses = new ArrayList<Address>();
}
