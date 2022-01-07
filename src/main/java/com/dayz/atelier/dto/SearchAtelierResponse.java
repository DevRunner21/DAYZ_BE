package com.dayz.atelier.dto;

import com.dayz.common.dto.CustomPageResponse;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchAtelierResponse extends CustomPageResponse<SearchAtelierResponse.AtelierResult> {

    private SearchAtelierResponse(Page tPage) {
        super(tPage);
    }

    public static SearchAtelierResponse of(Page tPage) {
        return new SearchAtelierResponse(tPage);
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AtelierResult {

        private Long atelierId;

        private String name;

        private String intro;

        private String imageUrl;

        @QueryProjection
        public AtelierResult(Long atelierId, String name, String intro, String imageUrl) {
            this.atelierId = atelierId;
            this.name = name;
            this.intro = intro;
            this.imageUrl = imageUrl;
        }

    }

}
