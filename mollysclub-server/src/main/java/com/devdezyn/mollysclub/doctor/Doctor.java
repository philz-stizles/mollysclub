package com.devdezyn.mollysclub.doctor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.devdezyn.mollysclub.address.Address;
import com.devdezyn.mollysclub.shared.models.BaseEntity;
import com.devdezyn.mollysclub.user.User;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity{
  private String specialization;
  private String mobile;
  private String gender;
  private Integer age;

  @OneToOne(cascade = CascadeType.ALL)
  private User user;

  @Builder
  public Doctor(Long id, String specialization, String mobile, String gender, Integer age, User user) {
    super(id);
    this.specialization = specialization;
    this.mobile = mobile;
    this.gender = gender;
    this.age = age;
    this.user = user;
  }

}
