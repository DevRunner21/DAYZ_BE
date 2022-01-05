package com.dayz.member.converter;

import com.dayz.member.domain.Address;
import com.dayz.member.dto.EditMemberAddressResponse;
import com.dayz.member.dto.ReadAddressesResponse;
import com.dayz.member.dto.ReadAddressesResponse.AddressByCityResult;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public ReadAddressesResponse convertToReadAddressesResponse(List<Address> addresses) {

        ReadAddressesResponse readAddressesResponse = ReadAddressesResponse.of();

        ConcurrentMap<Long, List<Address>> collect = addresses.stream()
            .collect(Collectors.groupingByConcurrent(Address::getCityId));

        collect.forEach((cityId, addressByCityList) -> {
            AddressByCityResult addressByCityResult = convertToAddressByCityResult(cityId,
                addressByCityList.get(0).getCityName(), addressByCityList);
            readAddressesResponse.addAddressByCityResult(addressByCityResult);
        });

        return readAddressesResponse;

    }

    public ReadAddressesResponse.AddressByCityResult convertToAddressByCityResult(Long cityId,
        String cityName, List<Address> addresses) {
        return ReadAddressesResponse.AddressByCityResult.of(
            cityId,
            cityName,
            addresses.stream()
                .map(this::convertToRegionByCityResult)
                .collect(Collectors.toList())
        );
    }

    public ReadAddressesResponse.AddressByCityResult.RegionByCityResult convertToRegionByCityResult(
        Address addressByCityId) {
        return ReadAddressesResponse.AddressByCityResult.RegionByCityResult
            .of(addressByCityId.getRegionId(), addressByCityId.getRegionName());
    }

    public EditMemberAddressResponse convertToEditMemberAddressResponse(Address address) {
        return EditMemberAddressResponse
            .of(address.getCityId(), address.getCityName(), address.getRegionId(),
                address.getRegionName());
    }

}
