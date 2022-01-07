package com.dayz.onedayclass.dto;

import com.dayz.common.dto.CustomPageResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadOneDayClassesByAtelierResponse extends CustomPageResponse<ReadOneDayClassesByAtelierResponse.OneDayClassResult> {

    private ReadOneDayClassesByAtelierResponse(Page tPage) {
        super(tPage);
    }

    public static ReadOneDayClassesByAtelierResponse of(Page tPage) {
        return new ReadOneDayClassesByAtelierResponse(tPage);
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassResult {

        private Long classId;

        private String name;

        private String imageUrl;

        public static OneDayClassResult of(Long oneDayClassId, String name, String imageUrl) {
            OneDayClassResult oneDayClassResult = new OneDayClassResult();
            oneDayClassResult.setClassId(oneDayClassId);
            oneDayClassResult.setName(name);
            oneDayClassResult.setImageUrl(imageUrl);

            return oneDayClassResult;
        }

    }

}
