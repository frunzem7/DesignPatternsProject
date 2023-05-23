package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.exception.HolidayPackageNotFoundException;
import com.example.designPatternsProject.models.entities.HolidayPackage;
import com.example.designPatternsProject.repository.Holidays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HolidayPackageServiceImpl implements HolidayPackageService {
    private final Holidays holidays;
    private final HolidayAdapter holidayAdapter;

    @Override
    public HolidayPackageDTO createHolidayPackage(HolidayPackageDTO holidayPackageDTO) {
        HolidayPackage entity = holidayPackageDTO.toHolidayPackageEntity();
        HolidayPackage holidayPackage = holidays.add(entity);
        return HolidayPackageDTO.toHolidayPackageDTO(holidayPackage);
    }

    @Override
    public List<HolidayPackageDTO> getAllHolidayPackage() {
        return holidays.findAll().stream()
                .map(HolidayPackageDTO::toHolidayPackageDTO)
                .toList();
    }

    @Override
    public HolidayPackageDTO getById(Long holidayPackageId) {
        return holidays.findById(holidayPackageId)
                .map(HolidayPackageDTO::toHolidayPackageDTO)
                .orElseThrow(() -> new HolidayPackageNotFoundException(String.format("Holiday package with id = %s not found.", holidayPackageId)));
    }

    @Override
    public HolidayPackageDTO updateHolidayPackage(Long id, HolidayPackageDTO holidayPackageDTO) {
        HolidayPackage holidayPackage = holidays.findById(id)
                .map(hp -> hp.toBuilder()
                        .description(holidayPackageDTO.getInformationHoliday().getDescription())
                        .activities(holidayPackageDTO.getInformationHoliday().getActivities())
                        .build())
                .orElseThrow(() -> new HolidayPackageNotFoundException(String.format("Holiday package with id = %s not found.", id)));
        new ChangeHolidayName(holidayPackage, holidayPackageDTO.getName()).execute();
        holidays.add(holidayPackage);

        return HolidayPackageDTO.toHolidayPackageDTO(holidayPackage);
    }

    @Override
    public void deleteHolidayPackageById(Long holidayPackageId) {
        HolidayPackage holidayPackage = holidays.findById(holidayPackageId)
                .orElseThrow(() -> new HolidayPackageNotFoundException(String.format("Holiday package with id = %s not found.", holidayPackageId)));

        holidays.delete(holidayPackage);
    }

    @Override
    public String getAllInformationInOneLine(Long id) {
        return holidayAdapter.getAllInformationInOneLine(getById(id));
    }
}
