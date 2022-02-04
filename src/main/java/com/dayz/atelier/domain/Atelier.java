package com.dayz.atelier.domain;

import com.dayz.common.entity.BaseEntity;
import com.dayz.member.domain.Address;
import com.dayz.member.domain.Member;
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
@Table(
    name = "atelier",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_business_number", columnNames = "business_number")
    }
)
public class Atelier extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atelier_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_atelier_to_address"))
    private Address address;

    @Column(name = "address_detail", nullable = false)
    private String detail;

    @Column(name = "intro", length = 1000)
    private String intro;

    @Column(name = "call_number", length = 20)
    private String callNumber;

    @Embedded
    private WorkTime workTime;

    @Column(name = "business_number", nullable = false, length = 20)
    private String businessNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_atelier_to_member"))
    private Member member;

    @Builder
    private Atelier(
        Long id,
        String name,
        Address address,
        String detail,
        String intro,
        String callNumber,
        WorkTime workTime,
        String businessNumber,
        Member member
    ) {
        Assert.notNull(name, "name must be net null");
        Assert.notNull(address, "name must be net null");
        Assert.notNull(detail, "detail must be net null");
        Assert.notNull(intro, "intro must be net null");
        Assert.notNull(callNumber, "callNumber must be net null");
        Assert.notNull(workTime, "workTime must be net null");
        Assert.notNull(businessNumber, "businessNumber must be net null");
        Assert.notNull(member, "member must be net null");

        this.id = id;
        this.name = name;
        this.address = address;
        this.detail = detail;
        this.intro = intro;
        this.callNumber = callNumber;
        this.workTime = workTime;
        this.businessNumber = businessNumber;
        changeMember(member);
    }

    public void changeMember(Member member) {
        this.member = member;
//        member.changeAtelier(this);
    }

}
