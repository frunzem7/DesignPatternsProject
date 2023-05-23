package com.example.designPatternsProject.service;

import com.example.designPatternsProject.models.entities.HolidayPackage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChangeHolidayName implements Command {
    private HolidayPackage holidayPackage;
    private String newName;

    @Override
    public void execute() {
        holidayPackage.setName(newName);
    }
}
