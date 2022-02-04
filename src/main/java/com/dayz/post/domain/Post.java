package com.dayz.post.domain;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_post_to_member"))
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "onedayclass_id", foreignKey = @ForeignKey(name = "fk_post_to_onedayclass"))
    private OneDayClass oneDayClass;

    @Builder.Default
    @OrderBy("sequence ASC")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostImage> postImages = new ArrayList<>();

    private Post(Long id, String content, Member member, OneDayClass oneDayClass, List<PostImage> postImages) {
        Assert.notNull(content, "content must be not null");
        Assert.notNull(member, "member must be not null");
        Assert.notNull(oneDayClass, "oneDayClass must be not null");

        this.id = id;
        this.content = content;
        this.member = member;
        this.oneDayClass = oneDayClass;

        if (Objects.nonNull(postImages) && !postImages.isEmpty()) {
            postImages.forEach(this::addPostImage);
        }
    }

    public void addPostImage(PostImage postImage) {
        postImage.changePost(this);
    }

}
