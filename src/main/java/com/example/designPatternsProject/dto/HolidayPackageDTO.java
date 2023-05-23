package com.example.designPatternsProject.dto;

import com.example.designPatternsProject.models.entities.HolidayPackage;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HolidayPackageDTO {
    private Long id;
    private String name;
    private InformationHoliday informationHoliday;

    public HolidayPackageDTO(Long id, String name, String description, String activities) {
        this.id = id;
        this.name = name;
        this.informationHoliday = new InformationHoliday(description, activities);
    }

    public static HolidayPackageDTO toHolidayPackageDTO(HolidayPackage holidayPackage) {
        return HolidayPackageDTO.builder()
                .id(holidayPackage.getId())
                .name(holidayPackage.getName())
                .informationHoliday(new InformationHoliday(holidayPackage.getDescription(), holidayPackage.getActivities()))
                .build();
    }

    public HolidayPackage toHolidayPackageEntity() {
        return HolidayPackage.builder()
                .id(id)
                .name(name)
                .description(informationHoliday.getDescription())
                .activities(informationHoliday.getActivities())
                .build();
    }
}
