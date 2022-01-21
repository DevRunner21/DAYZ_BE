package com.dayz.post.domain;

import com.dayz.common.entity.BaseEntity;
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
public class PostImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_image_id")
    private Long id;

    @Column(name = "image_file_name", nullable = false)
    private String imageFileName;

    @Column(name = "sequence")
    private int sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "fk_post_image_to_post"))
    private Post post;

    @Builder
    private PostImage(Long id, String imageFileName, int sequence, Post post) {
        Assert.notNull(imageFileName, "imageFileName must not be null.");
        Assert.isTrue(sequence > 0, "sequence must not positive.");

        this.id = id;
        this.imageFileName = imageFileName;
        this.sequence = sequence;
        changePost(post);
    }

    public void changePost(Post post) {
        if (Objects.nonNull(post)) {
            post.getPostImages().remove(this);
        }
        this.post = post;
        post.getPostImages().add(this);
    }

}
