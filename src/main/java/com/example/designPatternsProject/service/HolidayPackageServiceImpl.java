package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageCaretaker;
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
    public static final HolidayPackageCaretaker HOLIDAY_PACKAGE_CARETAKER = new HolidayPackageCaretaker();
    private final Holidays holidays;
    private final HolidayAdapter holidayAdapter;
    private final HolidayPackageVisitor holidayPackageVisitor;

    @Override
    public HolidayPackageDTO createHolidayPackage(HolidayPackageDTO holidayPackageDTO) {
        HolidayPackage entity = holidayPackageDTO.toHolidayPackageEntity();
        HolidayPackage holidayPackage = holidays.add(entity);
        HolidayPackageDTO holidayPackageDTO1 = HolidayPackageDTO.toHolidayPackageDTO(holidayPackage);
        HOLIDAY_PACKAGE_CARETAKER.saveMemento(holidayPackageDTO1.createMemento());
        return holidayPackageDTO1;
    }

    @Override
    public List<HolidayPackageDTO> getAllHolidayPackage() {
        return holidays.findAll().stream()
                .map(HolidayPackageDTO::toHolidayPackageDTO)
                .toList();
    }

    @Override
    public HolidayPackageDTO getById(Long holidayPackageId) {
        HolidayPackageDTO holidayPackageDTO = holidays.findById(holidayPackageId)
                .map(HolidayPackageDTO::toHolidayPackageDTO)
                .orElseThrow(() -> new HolidayPackageNotFoundException(String.format("Holiday package with id = %s not found.", holidayPackageId)));
        holidayPackageDTO.accept(holidayPackageVisitor);
        return holidayPackageDTO;
    }

    @Override
    public HolidayPackageDTO updateHolidayPackage(Long id, HolidayPackageDTO holidayPackageDTO) {
        HolidayPackage holidayPackage = holidays.findById(id)
                .map(hp -> hp.toBuilder()
                        .description(holidayPackageDTO.getInformationHolidayDTO().getDescription())
                        .activities(holidayPackageDTO.getInformationHolidayDTO().getActivities())
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
