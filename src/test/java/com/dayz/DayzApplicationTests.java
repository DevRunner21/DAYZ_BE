package com.dayz;

import com.dayz.common.jwt.Jwt;
import com.dayz.member.domain.Member;
import com.dayz.member.domain.MemberRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class DayzApplicationTests {

  @Autowired
  private Jwt jwt;

  @Autowired
  private MemberRepository memberRepository;

  @Test
  void contextLoads() {

    Member member = memberRepository.findById(1L).get();

    String token = jwt.sign(
        Jwt.Claims.from(
            member.getId(),
            member.getProviderId(),
            member.getUsername(),
            new String[]{member.getPermission().getName()}
        )
    );

    System.out.println("Token = " + token);

  }

}
