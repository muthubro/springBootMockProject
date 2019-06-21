package com.accelerate.demo.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.accelerate.demo.model.MobileFoodFacilityPermit;

import org.springframework.beans.factory.annotation.Autowired;

public class MobileFoodFacilityPermitRepositoryImpl implements MobileFoodFacilityPermitRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    public List<MobileFoodFacilityPermit> findByReceivedBetweenInclusive(Date start, Date end) {
        Query query = entityManager.createNativeQuery("SELECT * FROM mobile_food_facility_permits WHERE received BETWEEN :start AND :end",
                MobileFoodFacilityPermit.class)
            .setParameter("start", start, TemporalType.DATE)
            .setParameter("end", end, TemporalType.DATE);

        List<MobileFoodFacilityPermit> result = query.getResultList();
        return result;
    }
}
