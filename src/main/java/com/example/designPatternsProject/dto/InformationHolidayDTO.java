package com.example.designPatternsProject.dto;

import lombok.*;

@Setter
@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class InformationHolidayDTO {
    private String description;
    private String activities;
}
