package com.dayz.follow.domain;

import com.dayz.atelier.domain.Atelier;
import com.dayz.common.entity.BaseEntity;
import com.dayz.member.domain.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.util.Assert;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "use_flag = true")
@Table(name = "follow")
public class Follow extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_follow_to_member"))
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atelier_id", foreignKey = @ForeignKey(name = "fk_follow_to_atelier"))
    private Atelier atelier;

    public static Follow of(Long id, Member member, Atelier atelier) {
        Assert.notNull(member, "Member must not be null.");
        Assert.notNull(atelier, "Atelier must not be null.");

        Follow follow = new Follow();
        follow.setId(id);
        follow.changeMember(member);
        follow.changeAtelier(atelier);

        return follow;
    }

    public static Follow of(Member member, Atelier atelier) {
        Assert.notNull(member, "Member must not be null.");
        Assert.notNull(atelier, "Atelier must not be null.");

        Follow follow = new Follow();
        follow.changeMember(member);
        follow.changeAtelier(atelier);

        return follow;
    }

    public void changeMember(Member member) {
        this.setMember(member);
    }

    public void changeAtelier(Atelier atelier) {
        this.setAtelier(atelier);
    }

}
