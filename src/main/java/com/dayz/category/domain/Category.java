package com.dayz.category.domain;

import com.dayz.common.entity.BaseEntity;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.util.Assert;

@Entity
@Getter
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

    @Builder
    private Category(Long id, String name) {
        Assert.notNull(name, "name must be not null");

        this.id = id;
        this.name = name;
    }

}
