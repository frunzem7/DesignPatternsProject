package com.example.designPatternsProject.repository;

import com.example.designPatternsProject.models.entities.HolidayPackage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Primary
@Component
@RequiredArgsConstructor
final class HolidayDecorator implements Holidays {

    private final Holidays holidays;

    @Override
    public HolidayPackage add(HolidayPackage holidayPackage) {
        return holidays.add(holidayPackage);
    }

    @Override
    public List<HolidayPackage> findAll() {
        return holidays.findAll().stream().map(HolidayPackage::clone).toList();
    }

    @Override
    public Optional<HolidayPackage> findById(Long id) {
        return holidays.findById(id).map(HolidayPackage::clone);
    }

    @Override
    public void delete(HolidayPackage holidayPackage) {
        holidays.delete(holidayPackage);
    }
}
