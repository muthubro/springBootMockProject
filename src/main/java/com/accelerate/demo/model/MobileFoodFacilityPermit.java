package com.accelerate.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mobile_food_facility_permits")
public class MobileFoodFacilityPermit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long locationId;

    private String applicant;

    private String facilityType;

    private Long cnn;

    private String locationDescription;

    private String address;

    private String blockLot;

    private String block;

    private String lot;

    private String permit;

    private String status;

    private Double x;

    private Double y;

    private Double latitude;

    private Double longitude;

    private String schedule;

    private String dayshours;

    @Temporal(TemporalType.DATE)
    private Date noiSent;

    @Temporal(TemporalType.DATE)
    private Date approved;

    @Temporal(TemporalType.DATE)
    private Date received;

    private Integer priorPermit;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    public MobileFoodFacilityPermit() {}

    public MobileFoodFacilityPermit(Long locationId, String applicant, String facilityType, Long cnn,
            String locationDescription, String address, String blockLot, String block, String lot, String permit,
            String status, Double x, Double y, Double latitude, Double longitude, String schedule,
            String dayshours, Date noiSent, Date approved, Date received, Integer priorPermit, Date expirationDate) {
        this.locationId = locationId;
        this.applicant = applicant;
        this.facilityType = facilityType;
        this.cnn = cnn;
        this.locationDescription = locationDescription;
        this.address = address;
        this.blockLot = blockLot;
        this.block = block;
        this.lot = lot;
        this.permit = permit;
        this.status = status;
        this.x = x;
        this.y = y;
        this.latitude = latitude;
        this.longitude = longitude;
        this.schedule = schedule;
        this.dayshours = dayshours;
        this.noiSent = noiSent;
        this.approved = approved;
        this.received = received;
        this.priorPermit = priorPermit;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public Long getCnn() {
        return cnn;
    }

    public void setCnn(Long cnn) {
        this.cnn = cnn;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlockLot() {
        return blockLot;
    }

    public void setBlockLot(String blockLot) {
        this.blockLot = blockLot;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDayshours() {
        return dayshours;
    }

    public void setDayshours(String dayshours) {
        this.dayshours = dayshours;
    }

    public Date getNoiSent() {
        return noiSent;
    }

    public void setNoiSent(Date noiSent) {
        this.noiSent = noiSent;
    }

    public Date getApproved() {
        return approved;
    }

    public void setApproved(Date approved) {
        this.approved = approved;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    public Integer getPriorPermit() {
        return priorPermit;
    }

    public void setPriorPermit(Integer priorPermit) {
        this.priorPermit = priorPermit;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
