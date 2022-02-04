package com.dayz.atelier.converter;

import com.dayz.atelier.domain.Atelier;
import com.dayz.atelier.dto.response.ReadAtelierDetailResponse;
import com.dayz.atelier.dto.response.ReadAteliersResponse;
import com.dayz.atelier.dto.response.SaveAtelierResponse;
import com.dayz.member.domain.Address;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtelierConverter {

    public ReadAteliersResponse.AtelierResult convertToReadAteliersAtelierResult(Atelier atelier) {
        return ReadAteliersResponse.AtelierResult.of(
            atelier.getId(),
            atelier.getName(),
            atelier.getMember().getProfileImageUrl(),
            atelier.getIntro()
        );
    }

    public ReadAtelierDetailResponse convertToReadAtelierDetailResponse(Atelier atelier) {
        return ReadAtelierDetailResponse.of(
            atelier.getId(),
            atelier.getName(),
            atelier.getIntro(),
            getFullAddress(atelier.getAddress(), atelier.getDetail()),
            atelier.getCallNumber(),
            LocalTime.ofSecondOfDay(atelier.getWorkTime().getStartTime()),
            LocalTime.ofSecondOfDay(atelier.getWorkTime().getEndTime()),
            atelier.getMember().getProfileImageUrl()
        );
    }

    public SaveAtelierResponse convertToSaveAtelierResponse(Long atelierId, String token) {
        return SaveAtelierResponse.of(atelierId, token);
    }

    private String getFullAddress(Address address, String detail) {
        String cityName = address.getCityName();
        String regionName = address.getRegionName();

        return cityName + " " + regionName + " " + detail;
    }

}
