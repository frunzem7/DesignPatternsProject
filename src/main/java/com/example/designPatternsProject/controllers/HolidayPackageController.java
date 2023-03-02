package com.example.designPatternsProject.controllers;

import com.example.designPatternsProject.dto.HolidayPackageDTO;
import com.example.designPatternsProject.service.HolidayPackageService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("holiday-package")
@RequiredArgsConstructor
@Api(value = "Holiday Package API", tags = "Holiday Package")
public class HolidayPackageController {
    private final HolidayPackageService holidayPackageService;

    @ApiOperation(value = "Add holiday package.", notes = "Add holiday package and return a message that it was added " +
            "successfully.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Holiday package created successfully."),
            @ApiResponse(code = 400, message = "Invalid input or bad request."),
            @ApiResponse(code = 500, message = "Internal server error.")
    })
    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HolidayPackageDTO> createHolidayPackage(
            @ApiParam(value = "Holiday package to create.", required = true) @RequestBody HolidayPackageDTO holidayPackageDTO) {
        return ResponseEntity.ok(holidayPackageService.createHolidayPackage(holidayPackageDTO));
    }

    @ApiOperation(value = "Get all holiday packages.", notes = "Get all holiday packages and return a list of holiday " +
            "package DTOs.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of holiday packages retrieved successfully."),
            @ApiResponse(code = 500, message = "Internal server error.")
    })
    @GetMapping("/")
    public List<HolidayPackageDTO> getAllHolidayPackage() {
        return holidayPackageService.getAllHolidayPackage();
    }

    @ApiOperation(value = "Get holiday package by ID.", notes = "Get holiday package by ID and return a holiday " +
            "package DTO.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Holiday package retrieved successfully."),
            @ApiResponse(code = 400, message = "Invalid input or bad request."),
            @ApiResponse(code = 404, message = "Holiday package not found."),
            @ApiResponse(code = 500, message = "Internal server error.")
    })
    @GetMapping("/{id}")
    public HolidayPackageDTO getById(
            @ApiParam(value = "ID of the holiday package to retrieve.", required = true) @PathVariable Long id) throws Exception {
        return holidayPackageService.getById(id);
    }

    @ApiOperation(value = "Update holiday package.", notes = "Update holiday package and return a message that it " +
            "was updated successfully.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Holiday package updated successfully."),
            @ApiResponse(code = 400, message = "Invalid input or bad request."),
            @ApiResponse(code = 404, message = "Holiday package not found."),
            @ApiResponse(code = 500, message = "Internal server error.")
    })
    @PutMapping("/{id}")
    public HolidayPackageDTO updateHolidayPackage(
            @ApiParam(value = "ID of the holiday package to update.", required = true) @PathVariable Long id,
            @ApiParam(value = "Holiday package data to update.", required = true) @RequestBody HolidayPackageDTO holidayPackageDTO) {
        return holidayPackageService.updateHolidayPackage(id, holidayPackageDTO);
    }

    @ApiOperation(value = "Delete holiday package.", notes = "Delete holiday package by ID and return a message that " +
            "it was deleted successfully.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Holiday package deleted successfully."),
            @ApiResponse(code = 400, message = "Invalid input or bad request."),
            @ApiResponse(code = 404, message = "Holiday package not found."),
            @ApiResponse(code = 500, message = "Internal server error.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(holidayPackageService.deleteHolidayPackageById(id));
    }
}
