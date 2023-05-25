package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HolidayPackageVisitorImpl implements HolidayPackageVisitor {
    @Override
    public void visit(HolidayPackageDTO holidayPackageDTO) {
        log.info("Welcome to {} package!", holidayPackageDTO.getName());
    }
}
