package com.dayz.review.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadAvgScoreResponse {

    private double avgScore;

    public static ReadAvgScoreResponse of(double avgScore) {
        ReadAvgScoreResponse readAvgScoreResponse = new ReadAvgScoreResponse();
        readAvgScoreResponse.setAvgScore(avgScore);

        return readAvgScoreResponse;
    }

}
