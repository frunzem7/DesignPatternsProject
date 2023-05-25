package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;

public interface HolidayPackageVisitor {
    void visit(HolidayPackageDTO holidayPackageDTO);
}
