package com.dayz.review.domain;


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

    @Builder
    private ReviewImage(Long id, String imageFileName, int sequence, Review review) {
        Assert.notNull(imageFileName,"imageFileName must be not null.");
        Assert.isTrue(sequence > 0,"sequence must be positive.");

        this.id = id;
        this.imageFileName = imageFileName;
        this.sequence = sequence;
        this.review = review;
    }

    public void changeReview(Review review) {
        if (Objects.nonNull(this.review)) {
            review.getReviewImages().remove(this);
        }
        review.getReviewImages().add(this);
        this.review = review;
    }

}
