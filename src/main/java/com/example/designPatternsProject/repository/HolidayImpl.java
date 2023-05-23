package com.example.designPatternsProject.repository;

import com.example.designPatternsProject.models.entities.HolidayPackage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
final class HolidayImpl implements Holidays {

    private final HolidayPackageRepository holidayPackageRepository;

    @Override
    public HolidayPackage add(HolidayPackage holidayPackage) {
        return holidayPackageRepository.save(holidayPackage);
    }

    @Override
    public List<HolidayPackage> findAll() {
        return holidayPackageRepository.findAll();
    }

    @Override
    public Optional<HolidayPackage> findById(Long id) {
        return holidayPackageRepository.findById(id);
    }

    @Override
    public void delete(HolidayPackage holidayPackage) {
        holidayPackageRepository.delete(holidayPackage);
    }
}
