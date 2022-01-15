package com.dayz.review.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadAvgScoreResponse {

    @ApiModelProperty(value = "평균 평점", dataType = "number", example = "4")
    private double avgScore;

    public static ReadAvgScoreResponse of(double avgScore) {
        ReadAvgScoreResponse readAvgScoreResponse = new ReadAvgScoreResponse();
        readAvgScoreResponse.setAvgScore(avgScore);

        return readAvgScoreResponse;
    }

}
