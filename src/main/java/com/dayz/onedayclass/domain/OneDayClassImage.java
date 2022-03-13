package com.dayz.onedayclass.domain;

import com.dayz.common.entity.BaseImageEntity;
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
@Where(clause = "use_flag = true")
@Table(name = "onedayclass_iamge")
public class OneDayClassImage extends BaseImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "onedayclass_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "onedayclass_id", foreignKey = @ForeignKey(name = "fk_onedayclass_image_to_onedayclass"))
    private OneDayClass oneDayClass;

    @Builder
    private OneDayClassImage(Long id, String imageFileName, int sequence, OneDayClass oneDayClass) {
        super(imageFileName, sequence);
        Assert.notNull(oneDayClass, "oneDayClass must be not null");

        this.id = id;
        changeOneDayClass(oneDayClass);
    }

    public void changeOneDayClass(OneDayClass oneDayClass) {
        if (Objects.nonNull(oneDayClass)) {
            oneDayClass.getOneDayClassImages().remove(this);
            oneDayClass.getOneDayClassImages().add(this);
        }
        this.oneDayClass = oneDayClass;
    }

}
