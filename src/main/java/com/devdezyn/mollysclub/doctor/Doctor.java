package com.devdezyn.mollysclub.doctor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.devdezyn.mollysclub.address.Address;
import com.devdezyn.mollysclub.shared.models.BaseEntity;
import com.devdezyn.mollysclub.user.User;

import lombok.Data;

@Data
@Entity
public class Doctor extends BaseEntity{
  private String specialization;
  private String mobile;
  private String gender;
  private String email;
  private Integer age;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Address> addresses = new ArrayList<Address>();

  @OneToOne(cascade = CascadeType.ALL)
  private User account;
}
