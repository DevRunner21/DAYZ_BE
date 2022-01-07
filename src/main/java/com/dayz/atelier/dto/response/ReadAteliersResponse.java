package com.dayz.atelier.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import lombok.*;
import org.springframework.data.domain.Page;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadAteliersResponse extends CustomPageResponse<ReadAteliersResponse.AtelierResult> {

    private ReadAteliersResponse(Page tPage) {
        super(tPage);
    }

    public static ReadAteliersResponse of(Page tPage) {
        return new ReadAteliersResponse(tPage);
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AtelierResult {

        private Long atelierId;

        private String name;

        private String imageUrl;

        private String intro;

        public static AtelierResult of(Long atelierId, String name, String imageUrl, String intro) {
            AtelierResult atelierResult = new AtelierResult();
            atelierResult.setAtelierId(atelierId);
            atelierResult.setName(name);
            atelierResult.setIntro(intro);
            atelierResult.setImageUrl(imageUrl);

            return atelierResult;
        }

    }

}
