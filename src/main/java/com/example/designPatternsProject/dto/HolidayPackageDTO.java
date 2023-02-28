package com.example.designPatternsProject.dto;

import com.example.designPatternsProject.models.entities.HolidayPackage;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HolidayPackageDTO {
    private Long id;
    private String name;
    private String description;
    private String activities;

    public static HolidayPackageDTO toHolidayPackageDTO(HolidayPackage holidayPackage) {
        return HolidayPackageDTO.builder()
                .id(holidayPackage.getId())
                .name(holidayPackage.getName())
                .description(holidayPackage.getDescription())
                .activities(holidayPackage.getActivities())
                .build();
    }

    public HolidayPackage toHolidayPackageEntity() {
        return HolidayPackage.builder()
                .id(id)
                .name(name)
                .description(description)
                .activities(activities)
                .build();
    }
}
