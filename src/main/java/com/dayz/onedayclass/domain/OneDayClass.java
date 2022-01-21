package com.dayz.onedayclass.domain;

import com.dayz.atelier.domain.Atelier;
import com.dayz.category.domain.Category;
import com.dayz.common.entity.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import lombok.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_onedayclass_to_category"))
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atelier_id", foreignKey = @ForeignKey(name = "fk_onedayclass_to_atelier"))
    private Atelier atelier;

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
        Category category,
        Atelier atelier,
        List<OneDayClassImage> oneDayClassImages,
        List<Curriculum> curriculums
    ) {
        Assert.notNull(name, "name must be not null.");
        Assert.notNull(intro, "intro must be not null.");
        Assert.isTrue(price > 0, "price must be positive.");
        Assert.notNull(requiredTime, "requiredTime must be not null.");
        Assert.isTrue(maxPeopleNumber > 0, "maxPeopleNumber must be positive.");
        Assert.notNull(category, "category must be not null.");
        Assert.notNull(atelier, "atelier must be not null.");

        this.id = id;
        this.name = name;
        this.intro = intro;
        this.price = price;
        this.requiredTime = requiredTime;
        this.maxPeopleNumber = maxPeopleNumber;
        this.category = category;
        this.atelier = atelier;

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
