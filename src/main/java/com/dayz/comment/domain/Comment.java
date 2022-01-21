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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "fk_comment_to_post"))
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_comment_to_member"))
    private Member member;

    @Builder
    private Comment(Long id, String content, Post post, Member member) {
        Assert.notNull(content, "content must be not null");
        Assert.notNull(post, "post must be not null");
        Assert.notNull(member, "member must be not null");

        this.id = id;
        this.content = content;
        this.post = post;
        this.member = member;
    }

}
