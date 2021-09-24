package com.devdezyn.mollysclub.permission;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.devdezyn.mollysclub.role.Role;
import com.devdezyn.mollysclub.shared.models.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Permission")
@Table(
        name = "permissions",
        uniqueConstraints = {
                @UniqueConstraint(name = "permission_name_unique", columnNames = "name")
        })
public class Permission extends BaseEntity {
    

    @NotNull
    private String name;

    @NotNull
    private String description;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<Role> roles;
        
    @Builder
    public Permission(Long id, String name, String description) {
            super(id);
            this.name = name;
            this.description = description;
    }
    
}
