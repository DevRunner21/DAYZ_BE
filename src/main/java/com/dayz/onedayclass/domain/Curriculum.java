package com.dayz.onedayclass.domain;

import com.dayz.common.entity.BaseEntity;
import java.util.Objects;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import org.springframework.util.Assert;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "use_flag = true")
@Table(name = "curriculum")
public class Curriculum extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculum_id")
    private Long id;

    @Column(name = "step", nullable = false)
    private int step;

    @Column(name = "content", length = 1000, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "onedayclass_id", foreignKey = @ForeignKey(name = "fk_curriculum_to_onedayclass"))
    private OneDayClass oneDayClass;

    @Builder
    private Curriculum(Long id, int step, String content, OneDayClass oneDayClass) {
        Assert.isTrue(step > 0, "step must be positive");
        Assert.notNull(content, "content must be not null");
        Assert.notNull(oneDayClass, "oneDayClass must be not null");

        this.id = id;
        this.step = step;
        this.content = content;
        changeOneDayClass(oneDayClass);
    }


    public void changeOneDayClass(OneDayClass oneDayClass) {
        if (Objects.nonNull(oneDayClass)) {
            oneDayClass.getCurriculums().remove(this);
            oneDayClass.getCurriculums().add(this);
        }

        this.oneDayClass = oneDayClass;
    }

}
