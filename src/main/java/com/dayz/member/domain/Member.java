package com.dayz.member.domain;

import com.dayz.atelier.domain.Atelier;
import com.dayz.common.entity.BaseEntity;
import com.dayz.follow.domain.Follow;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import org.springframework.util.Assert;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Where(clause = "use_flag = true")
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String username;

    @Column(name = "provider")
    private String provider;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", foreignKey = @ForeignKey(name = "fk_member_to_permission"))
    private Permission permission;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_member_to_address"))
    private Address address;

    @OneToOne(optional = false, mappedBy = "member")
    private Atelier atelier;

    @Builder.Default
    @OneToMany(mappedBy = "member")
    private List<Follow> follows = new ArrayList<>();

    private Member(
        Long id,
        String username,
        String provider,
        String providerId,
        String profileImageUrl,
        Permission permission,
        Address address,
        Atelier atelier,
        List<Follow> follows
    ) {
        Assert.notNull(username, "username must not be null!");
        Assert.notNull(provider, "provider must not be null!");
        Assert.notNull(providerId, "providerId must not be null!");
        Assert.notNull(permission, "permission must not be null!");

        this.id = id;
        this.username = username;
        this.provider = provider;
        this.providerId = providerId;
        this.profileImageUrl = profileImageUrl;
        changePermission(permission);
        changeAddress(address);
        changeAtelier(atelier);

        if (Objects.nonNull(follows) && !follows.isEmpty()) {
            follows.forEach(this::addFollow);
        }
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    public void changeAtelier(Atelier atelier) {
        atelier.changeMember(this);
    }

    public void changePermission(Permission permission) {
        this.permission = permission;
    }

    public void changeUserName(String name) {
        this.username = name;
    }

    public void changeProfileImageUrl(String imageUrl) {
        this.profileImageUrl = imageUrl;
    }

    public void addFollow(Follow follow) {
        follow.changeMember(this);
    }

}
