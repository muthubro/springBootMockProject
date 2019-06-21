package com.accelerate.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.accelerate.demo.model.MobileFoodFacilityPermit;
import com.accelerate.demo.payload.PermitAddRequest;
import com.accelerate.demo.repository.MobileFoodFacilityPermitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/permit")
public class PermitController {

    @Autowired
    private MobileFoodFacilityPermitRepository permitRepository;

    @GetMapping("/applicant")
    public ResponseEntity<?> getPermitByApplicant(@RequestParam("applicant") String applicant) {
        List<MobileFoodFacilityPermit> permits = permitRepository.findByApplicant(applicant);
        return ResponseEntity.ok(permits);
    }

    @GetMapping("/expiration")
    public ResponseEntity<?> getPermitByExpirationDate(@RequestParam("expiration") String date) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date expirationDate = new Date();
        try {
            expirationDate = format.parse(date);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Date is not in mm-dd-yyyy format");
        }
        List<MobileFoodFacilityPermit> permits = permitRepository.findByExpirationDateLessThanEqualOrderByExpirationDateDesc(expirationDate);
        return ResponseEntity.ok(permits);
    }

    @GetMapping("/received")
    public ResponseEntity<?> getPermitByReceivedBetween(@RequestParam("start") String start,
                                                        @RequestParam("end") String end) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = format.parse(start);
            endDate = format.parse(end);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Date is not in mm-dd-yyyy format");
        }
        List<MobileFoodFacilityPermit> permits = permitRepository.findByReceivedBetweenInclusive(startDate, endDate);
        return ResponseEntity.ok(permits);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPermit(@RequestBody PermitAddRequest request) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date noiSent;
        Date approved;
        Date received;
        Date expirationDate;

        try {
            noiSent = format.parse(request.getNoiSent());
            approved = format.parse(request.getApproved());
            received = format.parse(request.getReceived());
            expirationDate = format.parse(request.getExpirationDate());
        }
        catch (Exception ex) { return ResponseEntity.badRequest().body("Invalid date format.");  }

        MobileFoodFacilityPermit permit = new MobileFoodFacilityPermit(request.getLocationId(), 
                                                                        request.getApplicant(), 
                                                                        request.getFacilityType(),
                                                                        request.getCnn(), 
                                                                        request.getLocationDescription(), 
                                                                        request.getAddress(), 
                                                                        request.getBlockLot(), 
                                                                        request.getBlock(), 
                                                                        request.getLot(), 
                                                                        request.getPermit(), 
                                                                        request.getStatus(), 
                                                                        request.getX(), 
                                                                        request.getY(), 
                                                                        request.getLatitude(), 
                                                                        request.getLongitude(), 
                                                                        request.getSchedule(), 
                                                                        request.getDayshours(), 
                                                                        noiSent, 
                                                                        approved, 
                                                                        received, 
                                                                        request.getPriorPermit(), 
                                                                        expirationDate);
        try {
            permit = permitRepository.save(permit);
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Could not save permit.");
        }

        return ResponseEntity.ok(permit);
    }

    @GetMapping("/delete/{locationId}")
    public ResponseEntity<?> deletePermit(@PathVariable("locationId") Long locationId) {
        MobileFoodFacilityPermit permit = permitRepository.findByLocationId(locationId);

        if (permit == null) {
            return ResponseEntity.status(404).body("Permit not found.");
        }

        try {
            permitRepository.delete(permit);
        }
        catch (Exception ex) { return ResponseEntity.status(500).body("Could not delete the permit."); }

        return ResponseEntity.ok("Deleted permit.");
    }
}
