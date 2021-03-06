package com.dayz.follow.domain;

import com.dayz.atelier.domain.Atelier;
import com.dayz.common.entity.BaseEntity;
import com.dayz.member.domain.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Objects;
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

    @Builder
    private Follow(Long id, Member member, Atelier atelier) {
        Assert.notNull(member, "Member must not be null.");
        Assert.notNull(atelier, "Atelier must not be null.");

        this.id = id;
        changeMember(member);
        this.atelier = atelier;
    }

    public void changeMember(Member member) {
        if (Objects.nonNull(member)) {
            member.getFollows().remove(this);
            member.getFollows().add(this);
        }
        this.member = member;
    }

}
