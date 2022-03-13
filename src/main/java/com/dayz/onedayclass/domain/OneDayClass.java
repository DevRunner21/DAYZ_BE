package com.dayz.onedayclass.domain;

import com.dayz.common.entity.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
@Builder
@Where(clause = "use_flag = true")
@Table(name = "onedayclass")
public class OneDayClass extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "onedayclass_id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "intro", length = 1000, nullable = false)
    private String intro;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "required_time", nullable = false)
    private Long requiredTime;

    @Column(name = "max_people_number", nullable = false)
    private int maxPeopleNumber;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "atelier_id")
    private Long atelierId;

    @Builder.Default
    @OrderBy("sequence ASC")
    @OneToMany(
        mappedBy = "oneDayClass",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    List<OneDayClassImage> oneDayClassImages = new ArrayList<>();

    @Builder.Default
    @OrderBy("step ASC")
    @OneToMany(
        mappedBy = "oneDayClass",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    List<Curriculum> curriculums = new ArrayList<>();

    private OneDayClass(
        Long id,
        String name,
        String intro,
        int price,
        Long requiredTime,
        int maxPeopleNumber,
        Long categoryId,
        Long atelierId,
        List<OneDayClassImage> oneDayClassImages,
        List<Curriculum> curriculums
    ) {
        Assert.notNull(name, "name must be not null.");
        Assert.notNull(intro, "intro must be not null.");
        Assert.isTrue(price > 0, "price must be positive.");
        Assert.notNull(requiredTime, "requiredTime must be not null.");
        Assert.isTrue(maxPeopleNumber > 0, "maxPeopleNumber must be positive.");
        Assert.notNull(categoryId, "categoryId must be not null.");
        Assert.notNull(atelierId, "atelierId must be not null.");

        this.id = id;
        this.name = name;
        this.intro = intro;
        this.price = price;
        this.requiredTime = requiredTime;
        this.maxPeopleNumber = maxPeopleNumber;
        this.categoryId = categoryId;
        this.atelierId = atelierId;
        this.oneDayClassImages = new ArrayList<>();
        this.curriculums = new ArrayList<>();

        if (Objects.nonNull(oneDayClassImages) && !oneDayClassImages.isEmpty()) {
            oneDayClassImages.forEach(this::addOneDayClassImage);
        }

        if (Objects.nonNull(curriculums) && !curriculums.isEmpty()) {
            curriculums.forEach(this::addCurriculum);
        }
    }

    private void addOneDayClassImage(OneDayClassImage oneDayClassImage) {
        oneDayClassImage.changeOneDayClass(this);
    }

    private void addCurriculum(Curriculum curriculum) {
        curriculum.changeOneDayClass(this);
    }

}
