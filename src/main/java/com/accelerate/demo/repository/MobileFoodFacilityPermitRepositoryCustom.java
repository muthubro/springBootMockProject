package com.accelerate.demo.repository;

import java.util.Date;
import java.util.List;

import com.accelerate.demo.model.MobileFoodFacilityPermit;

public interface MobileFoodFacilityPermitRepositoryCustom {

    public List<MobileFoodFacilityPermit> findByReceivedBetweenInclusive(Date start, Date end);
}
