package com.dayz.review.domain;


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
@Table(name = "review_image")
public class ReviewImage extends BaseImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", foreignKey = @ForeignKey(name = "fk_review_image_to_review"))
    private Review review;

    @Builder
    private ReviewImage(Long id, String imageFileName, int sequence, Review review) {
        super(imageFileName, sequence);

        Assert.notNull(review,"review must be not null.");
        this.id = id;
        this.review = review;
    }

    public void changeReview(Review review) {
        if (Objects.nonNull(this.review)) {
            review.getReviewImages().remove(this);
            review.getReviewImages().add(this);
        }
        this.review = review;
    }

}
