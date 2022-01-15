package com.dayz.review.domain;


import com.dayz.common.entity.BaseEntity;
import java.util.Objects;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.util.Assert;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "use_flag = true")
@Table(name = "review_image")
public class ReviewImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_image_id")
    private Long id;

    @Column(name = "image_file_name", nullable = false)
    private String imageFileName;

    @Column(name = "sequence")
    private int sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", foreignKey = @ForeignKey(name = "fk_review_image_to_review"))
    private Review review;

    public static ReviewImage of(Long id,
        String imageFileName,
        int sequence,
        Review review
    ) {
        Assert.notNull(id, "ReviewImage의 imageUrl 값이 null입니다");
        Assert.notNull(imageFileName, "ReviewImage의 imageUrl 값이 null입니다");
        Assert.notNull(sequence, "ReviewImage sequence null 입니다.");

        ReviewImage reviewImage = new ReviewImage();
        reviewImage.setId(id);
        reviewImage.setImageFileName(imageFileName);
        reviewImage.setSequence(sequence);
        reviewImage.changeReview(review);

        return reviewImage;
    }

    public static ReviewImage of(String imageFileName,
        int sequence,
        Review review
    ) {
        Assert.notNull(imageFileName, "ReviewImage의 imageFileName 값이 null입니다");
        Assert.notNull(sequence, "ReviewImage sequence null 입니다.");

        ReviewImage reviewImage = new ReviewImage();
        reviewImage.setImageFileName(imageFileName);
        reviewImage.setSequence(sequence);
        if (Objects.nonNull(review)) {
            reviewImage.setReview(review);
        }
        return reviewImage;
    }

    public static ReviewImage of(String imageFileName,
        int sequence) {
        Assert.notNull(imageFileName, "ReviewImage의 imageFileName 값이 null입니다");
        Assert.notNull(sequence, "ReviewImage sequence null 입니다.");

        ReviewImage reviewImage = new ReviewImage();
        reviewImage.setImageFileName(imageFileName);
        reviewImage.setSequence(sequence);

        return reviewImage;
    }

    public void changeReview(Review review) {
        if (Objects.nonNull(this.review)) {
            review.getReviewImages().remove(this);
        }
        review.getReviewImages().add(this);
        this.review = review;
    }

}
