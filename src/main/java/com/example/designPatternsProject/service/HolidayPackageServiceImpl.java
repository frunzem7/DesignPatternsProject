package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.exception.HolidayPackageNotFoundException;
import com.example.designPatternsProject.models.entities.HolidayPackage;
import com.example.designPatternsProject.repository.HolidayPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
                .map(HolidayPackageDTO::toHolidayPackageDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HolidayPackageDTO getById(Long holidayPackageId) throws Exception {
        return holidayPackageRepository.findById(holidayPackageId)
                .map(HolidayPackageDTO::toHolidayPackageDTO)
                .orElseThrow(() -> new Exception(String.format("Holiday package with id = " + holidayPackageId + " not found.")));
    }

    @Override
    public HolidayPackageDTO updateHolidayPackage(Long id, HolidayPackageDTO holidayPackageDTO) {
        Optional<HolidayPackage> optionalHolidayPackage = holidayPackageRepository.findById(id);
        if (optionalHolidayPackage.isPresent()) {
            HolidayPackage holidayPackage = optionalHolidayPackage.get();
            holidayPackage.setName(holidayPackageDTO.getName());
            holidayPackage.setDescription(holidayPackageDTO.getDescription());
            holidayPackage.setActivities(holidayPackageDTO.getActivities());
            holidayPackageRepository.save(holidayPackage);
        }
        return null;
    }

    @Override
    public String deleteHolidayPackageById(Long holidayPackageId) {
        try {
            holidayPackageRepository.deleteById(holidayPackageId);
        } catch (Exception e) {
            throw new HolidayPackageNotFoundException("Holiday package with id = " + holidayPackageId + " not found!");
        }
        return "Holiday package with id = " + holidayPackageId + " was deleted successfully!";
    }
}
