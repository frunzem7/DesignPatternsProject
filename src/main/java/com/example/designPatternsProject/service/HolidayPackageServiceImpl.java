package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.exception.HolidayPackageNotFoundException;
import com.example.designPatternsProject.models.entities.HolidayPackage;
import com.example.designPatternsProject.repository.HolidayPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HolidayPackageServiceImpl implements HolidayPackageService {
    private final HolidayPackageRepository holidayPackageRepository;

    @Override
    public HolidayPackageDTO createHolidayPackage(HolidayPackageDTO holidayPackageDTO) {
        HolidayPackage entity = holidayPackageDTO.toHolidayPackageEntity();
        HolidayPackage holidayPackage = holidayPackageRepository.save(entity);
        return HolidayPackageDTO.toHolidayPackageDTO(holidayPackage);
    }

    @Override
    public List<HolidayPackageDTO> getAllHolidayPackage() {
        return holidayPackageRepository.findAll().stream()
                .map(HolidayPackage::clone)
                .map(HolidayPackageDTO::toHolidayPackageDTO)
                .toList();
    }

    @Override
    public HolidayPackageDTO getById(Long holidayPackageId) {
        return holidayPackageRepository.findById(holidayPackageId)
                .map(HolidayPackage::clone)
                .map(HolidayPackageDTO::toHolidayPackageDTO)
                .orElseThrow(() -> new HolidayPackageNotFoundException(String.format("Holiday package with id = %s not found.", holidayPackageId)));
    }

    @Override
    public HolidayPackageDTO updateHolidayPackage(Long id, HolidayPackageDTO holidayPackageDTO) {
        HolidayPackage holidayPackage = holidayPackageRepository.findById(id).map(hp -> hp.toBuilder()
                        .name(holidayPackageDTO.getName())
                        .description(holidayPackageDTO.getDescription())
                        .activities(holidayPackageDTO.getActivities())
                        .build())
                .orElseThrow(() -> new HolidayPackageNotFoundException(String.format("Holiday package with id = %s not found.", id)));
        holidayPackageRepository.save(holidayPackage);

        return HolidayPackageDTO.toHolidayPackageDTO(holidayPackage);
    }

    @Override
    public void deleteHolidayPackageById(Long holidayPackageId) {
        HolidayPackage holidayPackage = holidayPackageRepository.findById(holidayPackageId)
                .orElseThrow(() -> new HolidayPackageNotFoundException(String.format("Holiday package with id = %s not found.", holidayPackageId)));

        holidayPackageRepository.delete(holidayPackage);
    }
}
