package com.dayz.member.domain;

import com.dayz.common.entity.BaseEntity;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "use_flag = true")
@Table(name = "permission")
public class Permission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public static Permission of(Long id, String name) {
        Permission permission = new Permission();
        permission.setId(id);
        permission.setName(name);
        return permission;
    }

    public static Permission of(String name) {
        Permission permission = new Permission();
        permission.setName(name);
        return permission;
    }

}
