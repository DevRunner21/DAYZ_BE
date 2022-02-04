package com.dayz.member.domain;

import com.dayz.common.entity.BaseEntity;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.util.Assert;

@Entity
@Getter
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

    @Builder
    private Address(Long id, Long cityId, Long regionId, String cityName, String regionName) {
        Assert.notNull(cityId, "cityId must be not null");
        Assert.notNull(regionId, "regionId must be not null");
        Assert.notNull(cityName, "cityName must be not null");
        Assert.notNull(regionName, "regionName must be not null");

        this.id = id;
        this.cityId = cityId;
        this.regionId = regionId;
        this.cityName = cityName;
        this.regionName = regionName;
    }

    public String getFullAddress(String detail) {
        return this.cityName + " " + this.regionName + " " + detail;
    }

}
