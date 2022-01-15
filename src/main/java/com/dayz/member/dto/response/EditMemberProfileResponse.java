package com.dayz.member.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EditMemberProfileResponse {

    @ApiModelProperty(value = "사용자 이름", dataType = "string", example = "김지훈")
    private String name;

    @ApiModelProperty(value = "사용자 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
    private String imageUrl;

    public static EditMemberProfileResponse of(String name, String imageUrl) {
        EditMemberProfileResponse editMemberProfileResponse = new EditMemberProfileResponse();
        editMemberProfileResponse.setName(name);
        editMemberProfileResponse.setImageUrl(imageUrl);

        return editMemberProfileResponse;
    }

}
