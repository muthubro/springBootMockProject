package com.accelerate.demo.repository;

import java.util.Date;
import java.util.List;

import com.accelerate.demo.model.MobileFoodFacilityPermit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileFoodFacilityPermitRepository extends JpaRepository<MobileFoodFacilityPermit, Long>, MobileFoodFacilityPermitRepositoryCustom {

    MobileFoodFacilityPermit findByLocationId(Long locationId);
    
    List<MobileFoodFacilityPermit> findByApplicant(String applicant);

    List<MobileFoodFacilityPermit> findByExpirationDateLessThanEqualOrderByExpirationDateDesc(Date expirationDate);
}
