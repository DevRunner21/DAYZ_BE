package com.dayz.onedayclass.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadOneDayClassesByCategoryResponse extends CustomPageResponse<ReadOneDayClassesByCategoryResponse.OneDayClassResult> {

    private ReadOneDayClassesByCategoryResponse(Page tPage) {
        super(tPage);
    }

    public static ReadOneDayClassesByCategoryResponse of(Page tPage) {
        return new ReadOneDayClassesByCategoryResponse(tPage);
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassResult {

        private Long classId;

        private String name;

        private String intro;

        private String imageUrl;

        public static OneDayClassResult of(Long classId, String name, String intro, String imageUrl) {
            OneDayClassResult oneDayClassResult = new OneDayClassResult();
            oneDayClassResult.setClassId(classId);
            oneDayClassResult.setName(name);
            oneDayClassResult.setIntro(intro);
            oneDayClassResult.setImageUrl(imageUrl);

            return oneDayClassResult;
        }

    }

}