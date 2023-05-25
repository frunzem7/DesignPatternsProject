package com.example.designPatternsProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HolidayPackageMemento {
    private String name;
    private InformationHolidayDTO informationHolidayDTO;

}
