package com.example.designPatternsProject.controllers;

import com.example.designPatternsProject.service.HolidayPackageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static com.example.designPatternsProject.utils.HolidayPackageUtils.HOLIDAY_PACKAGE_ONE;
import static com.example.designPatternsProject.utils.TestConstants.ID_ONE;
import static com.example.designPatternsProject.utils.HolidayPackageUtils.HOLIDAY_PACKAGE_DTO_ONE;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HolidayPackageController.class)
public class HolidayPackageControllerTest extends BaseController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private HolidayPackageService holidayPackageService;

    @Test
    @WithMockUser
    void shouldCreateHolidayPackage() throws Exception {
        when(holidayPackageService.createHolidayPackage(HOLIDAY_PACKAGE_DTO_ONE)).thenReturn(HOLIDAY_PACKAGE_DTO_ONE);

        mockMvc.perform(post("/holiday-package/")
                        .content(createRequest(HOLIDAY_PACKAGE_ONE))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(
                        createExpectedBody(HOLIDAY_PACKAGE_ONE)));

        verify(holidayPackageService).createHolidayPackage(HOLIDAY_PACKAGE_DTO_ONE);
    }

    @Test
    @WithMockUser
    void shouldReturnAllHolidayPackageTest() throws Exception {
        when(holidayPackageService.getAllHolidayPackage())
                .thenReturn(Collections.singletonList(HOLIDAY_PACKAGE_DTO_ONE));

        mockMvc.perform(get("/holiday-package/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(createExpectedBody(
                        Collections.singletonList(HOLIDAY_PACKAGE_DTO_ONE))));

        verify(holidayPackageService).getAllHolidayPackage();
    }

    @Test
    @WithMockUser
    void shouldReturnHolidayPackageByIdTest() throws Exception {
        when(holidayPackageService.getById(ID_ONE))
                .thenReturn(HOLIDAY_PACKAGE_DTO_ONE);

        mockMvc.perform(get("/holiday-package/{id}", ID_ONE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(createExpectedBody(HOLIDAY_PACKAGE_DTO_ONE)));

        verify(holidayPackageService).getById(ID_ONE);
    }

    @Test
    @WithMockUser
    void shouldDeleteHolidayPackageByIdTest() throws Exception {
        mockMvc.perform(delete("/holiday-package/{id}", HOLIDAY_PACKAGE_DTO_ONE.getId()))
                .andDo(print())
                .andExpect(status().isOk());

        verify(holidayPackageService).deleteHolidayPackageById(HOLIDAY_PACKAGE_DTO_ONE.getId());
    }
}
