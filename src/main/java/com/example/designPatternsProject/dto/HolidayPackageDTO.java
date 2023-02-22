package com.example.designPatternsProject.dto;

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
}
