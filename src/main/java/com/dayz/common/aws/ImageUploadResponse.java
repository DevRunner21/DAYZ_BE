package com.dayz.common.aws;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageUploadResponse {

    @ApiModelProperty(value = "업로드한 ImageUrl", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
    private String imageUrl;

    public static ImageUploadResponse of(String imageUrl) {
        ImageUploadResponse imageUploadResponse = new ImageUploadResponse();
        imageUploadResponse.setImageUrl(imageUrl);

        return imageUploadResponse;
    }

}
