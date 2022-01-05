package com.dayz.post.domain;

import com.dayz.common.entity.BaseEntity;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "post")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "onedayclass_id")
    private OneDayClass oneDayClass;

    @OrderBy("sequence ASC")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostImage> postImages = new ArrayList<>();

    public static Post of(Long id, String content, Member member, OneDayClass oneDayClass,
        List<PostImage> postImages) {
        Assert.notNull(content, "Content must not be null.");
        Assert.notNull(member, "Member must not be null.");
        Assert.notNull(oneDayClass, "OneDayClass must not be null.");

        Post post = new Post();
        post.setId(id);
        post.setContent(content);
        post.changeMember(member);
        post.changeOneDayClass(oneDayClass);
        postImages.forEach(post::addPostImage);

        return post;
    }

    public static Post of(String content, Member member, OneDayClass oneDayClass,
        List<PostImage> postImages) {
        Assert.notNull(content, "Content must not be null.");
        Assert.notNull(member, "Member must not be null.");
        Assert.notNull(oneDayClass, "oneDayClass must not be null.");

        Post post = new Post();
        post.setContent(content);
        post.changeMember(member);
        post.changeOneDayClass(oneDayClass);
        postImages.forEach(post::addPostImage);

        return post;
    }

    public void changeMember(Member member) {
        this.setMember(member);
    }

    public void changeOneDayClass(OneDayClass oneDayClass) {
        this.setOneDayClass(oneDayClass);
    }

    public void addPostImage(PostImage postImage) {
        postImage.changePost(this);
    }

}
