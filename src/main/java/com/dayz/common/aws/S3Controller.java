package com.dayz.common.aws;

import com.dayz.common.dto.CommonApiResponse;
import com.dayz.onedayclass.dto.response.ReadOneDayClassesByCategoryResponse;
import io.swagger.annotations.*;
import java.io.IOException;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "S3Controller V1", value = "S3 이미지 업로드 API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
public class S3Controller {

    @Value("${cloud.aws.s3.bucket_path}")
    private String BUCKET_ADDRESS;

    private final AwsS3Service awsS3Service;

    @ApiOperation(
        value = "이미지 업로드",
        notes = "S3에 이미지를 업로드합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = ImageUploadResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/v1/images")
    public CommonApiResponse createBoards(@RequestParam(value = "files", required = false) MultipartFile multipartFile) throws IOException {
        String uploadedUrl = awsS3Service.upload(multipartFile);

        return CommonApiResponse.ok(ImageUploadResponse.of(uploadedUrl));
    }

}
