package com.example.designPatternsProject.utils;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.models.entities.HolidayPackage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.example.designPatternsProject.utils.TestConstants.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HolidayPackageUtils {
    public static final HolidayPackage HOLIDAY_PACKAGE_ONE = HolidayPackage.builder()
            .id(ID_ONE)
            .name(NAME_ONE)
            .description(DESCRIPTION_ONE)
            .activities(ACTIVITIES_ONE)
            .build();
    public static final HolidayPackageDTO HOLIDAY_PACKAGE_DTO_ONE = HolidayPackageDTO.builder()
            .id(ID_ONE)
            .name(NAME_ONE)
            .description(DESCRIPTION_ONE)
            .activities(ACTIVITIES_ONE)
            .build();
}
