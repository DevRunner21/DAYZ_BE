package com.dayz.common.entity;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@MappedSuperclass
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseImageEntity extends BaseEntity {

    @Column(name = "image_file_name", nullable = false)
    protected String imageFileName;

    @Column(name = "sequence")
    protected int sequence;

    @Transient
//    @Value("${cloud.aws.s3.bucket_path}")
    private final String bucketPath = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/";

    protected BaseImageEntity(String imageFileName, int sequence) {
        Assert.notNull(imageFileName, "imageFileName must not be null.");
        Assert.isTrue(sequence > 0, "sequence must not positive.");

        this.imageFileName = extractImageFileName(imageFileName);
        this.sequence = sequence;
    }

    protected String extractImageFileName(String imageUrl) {
        return imageUrl.replace(bucketPath, "");
    }

    // TODO : Annotation + Filter로 분리예정
    public String getFullImageUrl() {
        return bucketPath.concat(this.imageFileName);
    }

}
