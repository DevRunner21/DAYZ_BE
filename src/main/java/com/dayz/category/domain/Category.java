package com.dayz.category.domain;

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
@Table(
    name = "category",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_category_name", columnNames = "name")
    }
)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public static Category of(Long id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        return category;
    }

    public static Category of(String name) {
        Category category = new Category();
        category.setName(name);

        return category;
    }

}
