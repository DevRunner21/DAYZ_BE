package com.dayz.post.domain;

import com.dayz.common.entity.BaseEntity;
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
@Where(clause = "use_flag = true")
@Table(name = "post")
@Builder
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "class_id", nullable = false)
    private Long oneDayClassId;

    @Builder.Default
    @OrderBy("sequence ASC")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostImage> postImages = new ArrayList<>();

    private Post(Long id, String content, Long memberId, Long oneDayClassId, List<PostImage> postImages) {
        Assert.notNull(content, "content must be not null");
        Assert.notNull(memberId, "memberId must be not null");
        Assert.notNull(oneDayClassId, "oneDayClassId must be not null");

        this.id = id;
        this.content = content;
        this.memberId = memberId;
        this.oneDayClassId = oneDayClassId;
        this.postImages = new ArrayList<>();

        if (Objects.nonNull(postImages) && !postImages.isEmpty()) {
            postImages.forEach(this::addPostImage);
        }
    }

    public void addPostImage(PostImage postImage) {
        postImage.changePost(this);
    }

}
