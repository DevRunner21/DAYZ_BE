package com.dayz.follow.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadFollowsResponse {

  @NotNull(message = "atelierId must not be null.")
  private Long atelierId;

  @NotBlank(message = "name must not be null.")
  private String name;

  @NotBlank(message = "imageFileName must not be null.")
  private String imageFileName;

  @NotBlank(message = "intro must not be null.")
  private String intro;

  public static ReadFollowsResponse of(Long atelierId, String name, String imageFileName,
      String intro) {
    ReadFollowsResponse readFollowsResponse = new ReadFollowsResponse();
    readFollowsResponse.setAtelierId(atelierId);
    readFollowsResponse.setName(name);
    readFollowsResponse.setImageFileName(imageFileName);
    readFollowsResponse.setIntro(intro);

    return readFollowsResponse;
  }

}
