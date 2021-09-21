package com.devdezyn.mollysclub.address;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.devdezyn.mollysclub.shared.models.BaseEntity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {
  private String zip;
  private String street;
  private String city;
  private String state;
  private String country;
}
