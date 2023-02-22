package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.repository.HolidayPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HolidayPackageImpl implements HolidayPackageService {
    private final HolidayPackageRepository holidayPackageRepository;

    @Override
    public HolidayPackageDTO saveHolidayPackage(HolidayPackageDTO holidayPackageDTO) {
        return null;
    }
}
