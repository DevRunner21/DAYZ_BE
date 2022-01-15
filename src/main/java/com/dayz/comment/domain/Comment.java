package com.dayz.comment.domain;

import com.dayz.common.entity.BaseEntity;
import com.dayz.member.domain.Member;
import com.dayz.post.domain.Post;
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

    public static Comment of(Long id, String content, Post post, Member member) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setContent(content);
        comment.changePost(post);
        comment.changeMember(member);

        return comment;
    }

    public static Comment of(String content, Post post, Member member) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.changePost(post);
        comment.changeMember(member);

        return comment;
    }

    public void changePost(Post post) {
        this.setPost(post);
    }

    public void changeMember(Member member) {
        this.setMember(member);
    }

}
