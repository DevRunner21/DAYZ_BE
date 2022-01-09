package com.dayz.member.dto.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EditMemberProfileRequest {

    @ApiModelProperty(value = "사용자 이름", dataType = "string", example = "김지훈")
    @NotBlank(message = "name must be not blank")
    private String name;

    @ApiModelProperty(value = "사용자 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
    @NotBlank(message = "imageUrl must be not blank")
    private String imageUrl;

    public static EditMemberProfileRequest of(String name, String imageUrl) {
        EditMemberProfileRequest editMemberProfileRequest = new EditMemberProfileRequest();
        editMemberProfileRequest.setName(name);
        editMemberProfileRequest.setImageUrl(imageUrl);

        return editMemberProfileRequest;
    }

}
