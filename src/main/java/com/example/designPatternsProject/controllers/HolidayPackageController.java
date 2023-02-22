package com.example.designPatternsProject.controllers;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.service.HolidayPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("holidayPackage")
@RequiredArgsConstructor
public class HolidayPackageController {
    private final HolidayPackageService holidayPackageService;

    @PostMapping("/save")
    public HolidayPackageDTO saveHolidayPackage(HolidayPackageDTO holidayPackageDTO) {
        return holidayPackageService.saveHolidayPackage(holidayPackageDTO);
    }
}
