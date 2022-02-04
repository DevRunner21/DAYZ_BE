package com.dayz.review.domain;

import com.dayz.common.entity.BaseEntity;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
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
@Table(name = "review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "score")
    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_review_to_member"))
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "onedayclass_id", foreignKey = @ForeignKey(name = "fk_review_to_onedayclass"))
    private OneDayClass oneDayClass;

    @Builder.Default
    @OrderBy("sequence ASC")
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewImage> reviewImages = new ArrayList<>();

    private Review(
        Long id,
        String content,
        int score,
        Member member,
        OneDayClass oneDayClass,
        List<ReviewImage> reviewImages
    ) {
        Assert.notNull(content, "content must be not null.");
        Assert.isTrue(score > 0, "score must be positive.");
        Assert.notNull(member, "member must be not null.");
        Assert.notNull(oneDayClass, "oneDayClass must be not null.");

        this.id = id;
        this.content = content;
        this.score = score;
        this.member = member;
        this.oneDayClass = oneDayClass;

        if (Objects.nonNull(reviewImages) && !reviewImages.isEmpty()) {
            reviewImages.forEach(this::addReviewImage);
        }
    }

    public void addReviewImage(ReviewImage reviewImage) {
        reviewImage.changeReview(this);
    }

}
