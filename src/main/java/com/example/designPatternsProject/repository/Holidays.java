package com.example.designPatternsProject.repository;

import com.example.designPatternsProject.models.entities.HolidayPackage;

import java.util.List;
import java.util.Optional;

public interface Holidays {

    HolidayPackage add(HolidayPackage holidayPackage);

    List<HolidayPackage> findAll();

    Optional<HolidayPackage> findById(Long id);

    void delete(HolidayPackage holidayPackage);
}
