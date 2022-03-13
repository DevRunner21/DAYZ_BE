package com.dayz.comment.domain;

import com.dayz.common.entity.BaseEntity;
import com.dayz.member.domain.Member;
import com.dayz.post.domain.Post;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import org.springframework.util.Assert;


@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "use_flag = true")
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Builder
    public Comment(Long id, String content, Long postId, Long memberId) {
        Assert.notNull(content, "content must be not null");
        Assert.notNull(postId, "postId must be not null");
        Assert.notNull(memberId, "memberId must be not null");

        this.id = id;
        this.content = content;
        this.postId = postId;
        this.memberId = memberId;
    }
}
