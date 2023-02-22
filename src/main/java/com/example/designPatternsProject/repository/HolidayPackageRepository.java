package com.example.designPatternsProject.repository;

import com.example.designPatternsProject.models.entities.HolidayPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayPackageRepository extends JpaRepository<HolidayPackage, Long> {
}
