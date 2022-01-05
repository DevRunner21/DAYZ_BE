package com.dayz.member.domain;

import com.dayz.common.entity.BaseEntity;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "use_flag = true")
@Table(name = "address")
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "region_id")
    private Long regionId;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "region_name")
    private String regionName;

    public static Address of(Long id, Long cityId, Long regionId, String cityName,
        String regionName) {
        Address address = new Address();
        address.setId(id);
        address.setCityId(cityId);
        address.setRegionId(regionId);
        address.setCityName(cityName);
        address.setRegionName(regionName);

        return address;
    }

    public static Address of(Long cityId, Long regionId, String cityName, String regionName) {
        Address address = new Address();
        address.setCityId(cityId);
        address.setRegionId(regionId);
        address.setCityName(cityName);
        address.setRegionName(regionName);

        return address;
    }

}
