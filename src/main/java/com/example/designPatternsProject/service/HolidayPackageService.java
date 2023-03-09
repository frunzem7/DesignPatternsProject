package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;

import java.util.List;

public interface HolidayPackageService {
    HolidayPackageDTO createHolidayPackage(HolidayPackageDTO holidayPackageDTO);

    List<HolidayPackageDTO> getAllHolidayPackage();

    HolidayPackageDTO getById(Long holidayPackageId);

    HolidayPackageDTO updateHolidayPackage(Long id, HolidayPackageDTO holidayPackageDTO);

    void deleteHolidayPackageById(Long holidayPackageId);
}
