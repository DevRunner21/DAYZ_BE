package com.dayz.post.domain;

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
@Table(name = "post_image")
public class PostImage extends BaseImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "fk_post_image_to_post"))
    private Post post;

    @Builder
    private PostImage(Long id, String imageFileName, int sequence, Post post) {
        super(imageFileName, sequence);
        this.id = id;
        changePost(post);
    }

    public void changePost(Post post) {
        if (Objects.nonNull(post)) {
            post.getPostImages().remove(this);
            post.getPostImages().add(this);
        }
        this.post = post;
    }

}
