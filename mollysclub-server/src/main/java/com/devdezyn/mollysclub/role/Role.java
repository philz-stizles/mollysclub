package com.devdezyn.mollysclub.role;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.devdezyn.mollysclub.permission.Permission;
import com.devdezyn.mollysclub.shared.models.BaseEntity;
import com.devdezyn.mollysclub.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Role")
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(name = "role_name_unique", columnNames = "name")
        })
public class Role extends BaseEntity {
    @Column(length = 60)
    private String name;

    private String description;

    @Column( name = "is_active", columnDefinition = "tinyint(1) default false")
    private Boolean isActive;

    @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "role_permissions",
                joinColumns = @JoinColumn(name = "role_id"),
                inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users;
    
    @Builder
    public Role(Long id, String name, String description, Boolean isActive, Set<Permission> permissions) {
            super(id);
            this.name = name;
            this.description = description;
            this.permissions = permissions;
            this.isActive = isActive;
    }
}
