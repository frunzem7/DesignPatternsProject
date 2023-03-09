package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.models.entities.HolidayPackage;
import com.example.designPatternsProject.repository.HolidayPackageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.designPatternsProject.utils.HolidayPackageUtils.*;
import static com.example.designPatternsProject.utils.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HolidayPackageServiceImplTest {
    @Mock
    private HolidayPackageRepository holidayPackageRepository;
    @InjectMocks
    private HolidayPackageServiceImpl holidayPackageService;

    @Test
    void shouldCreateHolidayPackage() {
        when(holidayPackageRepository.save(any(HolidayPackage.class))).thenReturn(HOLIDAY_PACKAGE_ONE);

        HolidayPackageDTO result = holidayPackageService.createHolidayPackage(HOLIDAY_PACKAGE_DTO_ONE);

        assertAll(
                () -> assertEquals(HOLIDAY_PACKAGE_ONE.getId(), result.getId()),
                () -> assertEquals(HOLIDAY_PACKAGE_ONE.getDescription(), result.getDescription()),
                () -> assertEquals(HOLIDAY_PACKAGE_ONE.getActivities(), result.getActivities())
        );
    }

    @Test
    void shouldReturnAllHolidayPackage() {
        final List<HolidayPackageDTO> expectedList = Collections.singletonList(HOLIDAY_PACKAGE_DTO_ONE);

        when(holidayPackageRepository.findAll()).thenReturn(Collections.singletonList(HOLIDAY_PACKAGE_ONE));

        List<HolidayPackageDTO> actualList = holidayPackageService.getAllHolidayPackage();

        assertEquals(expectedList, actualList);
    }

    @Test
    void shouldReturnHolidayPackageById() throws Exception {
        when(holidayPackageRepository.findById(ID_ONE)).thenReturn(Optional.of(HOLIDAY_PACKAGE_ONE));

        HolidayPackageDTO actualHolidayPackageDto = holidayPackageService.getById(ID_ONE);

        assertEquals(HOLIDAY_PACKAGE_DTO_ONE, actualHolidayPackageDto);
    }

    @Test
    void shouldDeleteHolidayPackageById() {
        when(this.holidayPackageRepository.findById(ID_ONE)).thenReturn(Optional.of(HOLIDAY_PACKAGE_ONE));

        this.holidayPackageService.deleteHolidayPackageById(ID_ONE);

        verify(this.holidayPackageRepository).delete(HOLIDAY_PACKAGE_ONE);
    }
}
