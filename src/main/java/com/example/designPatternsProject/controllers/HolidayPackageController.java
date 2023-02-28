package com.example.designPatternsProject.controllers;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.service.HolidayPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("holiday-package")
@RequiredArgsConstructor
public class HolidayPackageController {
    private final HolidayPackageService holidayPackageService;

    @PostMapping("/")
    public ResponseEntity<HolidayPackageDTO> createHolidayPackage(@RequestBody HolidayPackageDTO holidayPackageDTO) {
        return ResponseEntity.ok(holidayPackageService.createHolidayPackage(holidayPackageDTO));
    }

    @GetMapping("/")
    public List<HolidayPackageDTO> getAllHolidayPackage() {
        return holidayPackageService.getAllHolidayPackage();
    }

    @GetMapping("/{id}")
    public HolidayPackageDTO getById(@PathVariable Long id) throws Exception {
        return holidayPackageService.getById(id);
    }

    @PutMapping("/{id}")
    public HolidayPackageDTO updateHolidayPackage(@PathVariable Long id, @RequestBody HolidayPackageDTO holidayPackageDTO) {
        return holidayPackageService.updateHolidayPackage(id, holidayPackageDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(holidayPackageService.deleteHolidayPackageById(id));
    }
}
