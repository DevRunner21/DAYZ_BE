package com.dayz.post.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterPostRequest {

    @ApiModelProperty(value = "공방 ID", dataType = "long", example = "1")
    @NotNull(message = "atelierId must be not null")
    private Long atelierId;

    @ApiModelProperty(value = "원데이클래스 ID", dataType = "number", example = "1")
    @NotNull(message = "oneDayClassId must be not null")
    private Long oneDayClassId;

    @ApiModelProperty(value = "게시글 내용", dataType = "string", example = "내일 토우 모양 도자기를 만들껍니다!! 너무 이쁘죠??")
    private String content;

    @ApiModelProperty(value = "게시글 이미지 목록", dataType = "array")
    @Valid
    @NotNull(message = "postImages must be not null")
    private List<PostImageParam> images = new ArrayList<>();

    public static RegisterPostRequest of(String content, Long atelierId, Long oneDayClassId,
        List<PostImageParam> images) {
        RegisterPostRequest registerPostRequest = new RegisterPostRequest();
        registerPostRequest.setContent(content);
        registerPostRequest.setAtelierId(atelierId);
        registerPostRequest.setOneDayClassId(oneDayClassId);
        if (images.size() > 0) {
            registerPostRequest.setImages(images);
        }

        return registerPostRequest;
    }

    @ApiModel(value = "RegisterPostRequest.PostImageParam")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PostImageParam {

        @ApiModelProperty(value = "게시글 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
        @NotBlank(message = "imageUrl must be not blank")
        private String imageUrl;

        @ApiModelProperty(value = "게시글 이미지 순번", dataType = "integer", example = "1")
        @Min(value = 1, message = "sequence must be greater than 1")
        @Positive(message = "sequence must be positive")
        private int sequence;

        public static PostImageParam of(String imageUrl, int sequence) {
            PostImageParam postImageParam = new PostImageParam();
            postImageParam.setSequence(sequence);
            postImageParam.setImageUrl(imageUrl);

            return postImageParam;
        }

    }

}
