package com.dayz.onedayclass.controller;

import com.dayz.common.dto.CommonApiResponse;
import com.dayz.onedayclass.dto.response.ReadOneDayClassTimesByDateResponse;
import com.dayz.onedayclass.service.OneDayClassTimeService;
import javax.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/classtimes")
@Validated
public class OneDayClassTimeController {

    private final OneDayClassTimeService oneDayClassTimeService;

    @GetMapping("/classes/{classId}")
    public CommonApiResponse<ReadOneDayClassTimesByDateResponse> readOneDayClassTimesByDate(
        @RequestParam("date")
        @Pattern(
            regexp = "^(19[0-9]{2}|2[0-9]{3})-(0[1-9]|1[012])-([123]0|[012][1-9]|31)$",
            message = "date must be YYYY-MM-DD format"
        ) String date,
        @PathVariable("classId") Long classId
    ) {
        ReadOneDayClassTimesByDateResponse oneDayClassTimesByDateResponse
            = oneDayClassTimeService.getOneDayClassTimesByDate(classId, date);

        return CommonApiResponse.ok(oneDayClassTimesByDateResponse);
    }

}
