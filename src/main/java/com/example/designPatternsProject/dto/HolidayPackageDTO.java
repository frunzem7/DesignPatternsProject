package com.example.designPatternsProject.dto;

import com.example.designPatternsProject.models.entities.HolidayPackage;
import com.example.designPatternsProject.service.HolidayPackageVisitor;
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
    private InformationHolidayDTO informationHolidayDTO;

    public static HolidayPackageDTO toHolidayPackageDTO(HolidayPackage holidayPackage) {
        return HolidayPackageDTO.builder()
                .id(holidayPackage.getId())
                .name(holidayPackage.getName())
                .informationHolidayDTO(new InformationHolidayDTO(holidayPackage.getDescription(), holidayPackage.getActivities()))
                .build();
    }

    public HolidayPackage toHolidayPackageEntity() {
        return HolidayPackage.builder()
                .id(id)
                .name(name)
                .description(informationHolidayDTO.getDescription())
                .activities(informationHolidayDTO.getActivities())
                .build();
    }

    public void accept(HolidayPackageVisitor holidayPackageVisitor) {
        holidayPackageVisitor.visit(this);
    }

    public HolidayPackageMemento createMemento() {
        return new HolidayPackageMemento(name, informationHolidayDTO);
    }

    public void restoreMemento(HolidayPackageMemento memento) {
        this.name = memento.getName();
        this.informationHolidayDTO = memento.getInformationHolidayDTO();
    }
}
