package com.dayz.atelier.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadAtelierDetailResponse {

    @ApiModelProperty(value = "공방 ID", dataType = "long", example = "1")
    private Long atelierId;

    @ApiModelProperty(value = "공방 이름", dataType = "string", example = "지훈공방")
    private String name;

    @ApiModelProperty(value = "공방 소개", dataType = "string", example = "안녕하세요~! 지훈공방입니다.")
    private String intro;

    @ApiModelProperty(value = "공방 주소", dataType = "string", example = "강남구 자곡동 율암빌딩 2층 201호")
    private String address;

    @ApiModelProperty(value = "공방 전화번호", dataType = "string", example = "0312234544")
    private String callNumber;

    @ApiModelProperty(value = "공방 오픈시간", dataType = "string", example = "09:30")
    private String startTime;

    @ApiModelProperty(value = "공방 마감시간", dataType = "string", example = "19:30")
    private String endTime;

    @ApiModelProperty(value = "공방 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
    private String imageUrl;

    public static ReadAtelierDetailResponse of(
        Long atelierId,
        String name,
        String intro,
        String address,
        String callNumber,
        String startTime,
        String endTime,
        String imageUrl
    ) {
        ReadAtelierDetailResponse readAtelierDetailResponse = new ReadAtelierDetailResponse();
        readAtelierDetailResponse.setAtelierId(atelierId);
        readAtelierDetailResponse.setName(name);
        readAtelierDetailResponse.setIntro(intro);
        readAtelierDetailResponse.setAddress(address);
        readAtelierDetailResponse.setCallNumber(callNumber);
        readAtelierDetailResponse.setStartTime(startTime);
        readAtelierDetailResponse.setEndTime(endTime);
        readAtelierDetailResponse.setImageUrl(imageUrl);

        return readAtelierDetailResponse;
    }

}
