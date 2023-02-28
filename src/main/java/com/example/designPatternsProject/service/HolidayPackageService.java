package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;

import java.util.List;

public interface HolidayPackageService {
    HolidayPackageDTO createHolidayPackage(HolidayPackageDTO holidayPackageDTO);

    List<HolidayPackageDTO> getAllHolidayPackage();

    HolidayPackageDTO getById(Long holidayPackageId) throws Exception;

    HolidayPackageDTO updateHolidayPackage(Long id, HolidayPackageDTO holidayPackageDTO);

    String deleteHolidayPackageById(Long holidayPackageId);
}
