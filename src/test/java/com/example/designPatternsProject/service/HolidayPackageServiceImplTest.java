package com.example.designPatternsProject.service;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.repository.HolidayPackageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.example.designPatternsProject.utils.HolidayPackageUtils.HOLIDAY_PACKAGE_DTO_ONE;
import static com.example.designPatternsProject.utils.HolidayPackageUtils.HOLIDAY_PACKAGE_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HolidayPackageServiceImplTest {
    @Mock
    private HolidayPackageRepository holidayPackageRepository;
    @Mock
    HolidayPackageService holidayPackageService;

    @Test
    void shouldReturnAllHolidayPackage() {
        final List<HolidayPackageDTO> expectedList = Collections.singletonList(HOLIDAY_PACKAGE_DTO_ONE);

        when(holidayPackageRepository.findAll()).thenReturn(Collections.singletonList(HOLIDAY_PACKAGE_ONE));

        List<HolidayPackageDTO> actualList = holidayPackageService.getAllHolidayPackage();

        assertEquals(expectedList, actualList);
    }
}
