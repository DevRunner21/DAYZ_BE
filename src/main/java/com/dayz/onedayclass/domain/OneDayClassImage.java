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
    @JoinColumn(name = "onedayclass_id")
    private OneDayClass oneDayClass;

    public static OneDayClassImage of(Long id,
        String imageFileName,
        int sequence,
        OneDayClass oneDayClass
    ) {
        OneDayClassImage oneDayClassImage = new OneDayClassImage();
        oneDayClassImage.setId(id);
        oneDayClassImage.setImageFileName(imageFileName);
        oneDayClassImage.setSequence(sequence);
        oneDayClassImage.changeOneDayClass(oneDayClass);

        return oneDayClassImage;
    }

    public static OneDayClassImage of(
        String imageFileName,
        int sequence,
        OneDayClass oneDayClass
    ) {
        OneDayClassImage oneDayClassImage = new OneDayClassImage();
        oneDayClassImage.setImageFileName(imageFileName);
        oneDayClassImage.setSequence(sequence);
        oneDayClassImage.changeOneDayClass(oneDayClass);

        return oneDayClassImage;
    }

    public static OneDayClassImage of(
        String imageFileName,
        int sequence
    ) {
        OneDayClassImage oneDayClassImage = new OneDayClassImage();
        oneDayClassImage.setImageFileName(imageFileName);
        oneDayClassImage.setSequence(sequence);

        return oneDayClassImage;
    }

    public void changeOneDayClass(OneDayClass oneDayClass) {
        if (Objects.nonNull(oneDayClass)) {
            oneDayClass.getOneDayClassImages().remove(this);
        }
        this.setOneDayClass(oneDayClass);
        oneDayClass.getOneDayClassImages().add(this);
    }

}
