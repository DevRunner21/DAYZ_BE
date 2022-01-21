package com.dayz.onedayclass.domain;

import com.dayz.common.entity.BaseEntity;
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
public class OneDayClassImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "onedayclass_image_id")
    private Long id;

    @Column(name = "image_file_name", nullable = false)
    private String imageFileName;

    @Column(name = "sequence", nullable = false)
    private int sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "onedayclass_id", foreignKey = @ForeignKey(name = "fk_onedayclass_image_to_onedayclass"))
    private OneDayClass oneDayClass;

    @Builder
    private OneDayClassImage(Long id, String imageFileName, int sequence, OneDayClass oneDayClass) {
        Assert.notNull(imageFileName, "imageFileName must be not null");
        Assert.isTrue(sequence > 0, "sequence must be positive");
        Assert.notNull(oneDayClass, "oneDayClass must be not null");

        this.id = id;
        this.imageFileName = imageFileName;
        this.sequence = sequence;
        changeOneDayClass(oneDayClass);
    }

    public void changeOneDayClass(OneDayClass oneDayClass) {
        if (Objects.nonNull(oneDayClass)) {
            oneDayClass.getOneDayClassImages().remove(this);
        }
        this.oneDayClass = oneDayClass;
        oneDayClass.getOneDayClassImages().add(this);
    }

}
