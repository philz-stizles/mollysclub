package com.devdezyn.mollysclub.address;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.devdezyn.mollysclub.shared.models.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {
  private String zip;
  private String street;
  private String city;
  private String state;
  private String country;

  @Builder
  public Address(Long id, String zip, String street, String city, String state, String country) {
    super(id);
    this.zip = zip;
    this.street = street;
    this.city = city;
    this.state = state;
    this.country = country;
  }

}
