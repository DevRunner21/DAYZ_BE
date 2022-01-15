package com.dayz.member.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadMemberInfoResponse {

    @ApiModelProperty(value = "사용자 ID", dataType = "number", example = "1")
    private Long id;

    @ApiModelProperty(value = "사용자 토큰", dataType = "string", example = "asdasjdhsadlaskdlasmdian")
    private String token;

    @ApiModelProperty(value = "사용자 이름", dataType = "string", example = "김지훈")
    private String name;

    @ApiModelProperty(value = "사용자 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
    private String profileImageUrl;

    @ApiModelProperty(value = "시/군/구 ID", dataType = "number", example = "1")
    private Long cityId;

    @ApiModelProperty(value = "시/군/구 이름", dataType = "string", example = "강남구")
    private String cityName;

    @ApiModelProperty(value = "동 ID", dataType = "number", example = "1")
    private Long regionId;

    @ApiModelProperty(value = "동 이름", dataType = "string", example = "자곡동")
    private String regionName;

    @ApiModelProperty(value = "권한", dataType = "string", example = "ROLE_USER")
    private String auth;

    @ApiModelProperty(value = "소유 공방 ID", dataType = "number", example = "1")
    private Long atelierId;

    public static ReadMemberInfoResponse of(Long id, String token, String name, String profileImageUrl, Long cityId, String cityName, Long regionId,
            String regionName, String auth, Long atelierId) {
        Assert.notNull(id,"id must not be null!");
        Assert.notNull(token,"token must not be null!");
        Assert.notNull(name,"name must not be null!");
//        Assert.notNull(profileImageUrl,"profileImageUrl must not be null!");
        Assert.notNull(auth,"auth must not be null!");

        ReadMemberInfoResponse readMemberInfoResponse = new ReadMemberInfoResponse();
        readMemberInfoResponse.setId(id);
        readMemberInfoResponse.setToken(token);
        readMemberInfoResponse.setName(name);
        readMemberInfoResponse.setProfileImageUrl(profileImageUrl);
        readMemberInfoResponse.setCityId(cityId);
        readMemberInfoResponse.setCityName(cityName);
        readMemberInfoResponse.setRegionId(regionId);
        readMemberInfoResponse.setRegionName(regionName);
        readMemberInfoResponse.setAuth(auth);
        readMemberInfoResponse.setAtelierId(atelierId);

        return readMemberInfoResponse;
    }
}
