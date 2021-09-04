package com.devdezyn.mollysclub.permission;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "Permission")
@Table(
        name = "permission",
        uniqueConstraints = {
                @UniqueConstraint(name = "permission_name_unique", columnNames = "name")
        })
public class Permission {
    @Id
    @SequenceGenerator(
            name = "permission_sequence",
            sequenceName = "permission_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "permission_sequence"
    )
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
