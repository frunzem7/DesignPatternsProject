package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import org.springframework.stereotype.Component;

@Component
public class HolidayAdapterImpl implements HolidayAdapter {
    @Override
    public String getAllInformationInOneLine(HolidayPackageDTO holidayPackageDTO) {
        return ("Welcome to %s holiday. " +
                "Here you can find a small description about your holiday: %s. " +
                "This are your plan activities: %s.").formatted(holidayPackageDTO.getName(),
                holidayPackageDTO.getInformationHoliday().getDescription(),
                holidayPackageDTO.getInformationHoliday().getActivities());
    }
}
