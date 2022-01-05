package com.dayz;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DayzApplicationTests {

  @Test
  void contextLoads() {
    System.out.println(LocalDateTime.now());
  }

}
