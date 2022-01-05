package com.dayz.onedayclass.domain;

import com.dayz.common.entity.BaseEntity;
import java.util.Objects;
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
    @JoinColumn(name = "onedayclass_id")
    private OneDayClass oneDayClass;

    public static Curriculum of(Long id,
        int step,
        String content,
        OneDayClass oneDayClass
    ) {
        Curriculum curriculum = new Curriculum();
        curriculum.setId(id);
        curriculum.setStep(step);
        curriculum.setContent(content);
        curriculum.changeOneDayClass(oneDayClass);

        return curriculum;
    }

    public static Curriculum of(int step,
        String content,
        OneDayClass oneDayClass
    ) {
        Curriculum curriculum = new Curriculum();
        curriculum.setStep(step);
        curriculum.setContent(content);
        curriculum.changeOneDayClass(oneDayClass);

        return curriculum;
    }

    public static Curriculum of(int step,
        String content
    ) {
        Curriculum curriculum = new Curriculum();
        curriculum.setStep(step);
        curriculum.setContent(content);

        return curriculum;
    }

    public void changeOneDayClass(OneDayClass oneDayClass) {
        if (Objects.nonNull(oneDayClass)) {
            oneDayClass.getCurriculums().remove(this);
        }

        this.setOneDayClass(oneDayClass);
        oneDayClass.getCurriculums().add(this);
    }

}
