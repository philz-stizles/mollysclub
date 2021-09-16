package com.devdezyn.mollysclub.pharmacy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.devdezyn.mollysclub.address.Address;
import com.devdezyn.mollysclub.location.Location;
import com.devdezyn.mollysclub.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pharmacy")
@Table(
        name = "pharmacy",
        uniqueConstraints = {
                @UniqueConstraint(name = "pharmacy_name_unique", columnNames = "name")
        })
public class Pharmacy {
    @Id
    @SequenceGenerator(
            name = "pharmacy_sequence",
            sequenceName = "pharmacy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pharmacy_sequence"
    )
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String logo;
    private String bio;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<Address>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<Location>();

    @OneToOne(cascade = CascadeType.ALL)
        private User account;
}
