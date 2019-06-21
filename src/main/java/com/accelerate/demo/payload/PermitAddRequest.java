package com.accelerate.demo.payload;

public class PermitAddRequest {

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

    private String noiSent;

    private String approved;

    private String received;

    private Integer priorPermit;

    private String expirationDate;

    public PermitAddRequest() {}

    public PermitAddRequest(Long locationId, String applicant, String facilityType, Long cnn,
            String locationDescription, String address, String blockLot, String block, String lot, String permit,
            String status, Double x, Double y, Double latitude, Double longitude, String schedule, String dayshours,
            String noiSent, String approved, String received, Integer priorPermit, String expirationDate) {
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

    public String getNoiSent() {
        return noiSent;
    }

    public void setNoiSent(String noiSent) {
        this.noiSent = noiSent;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public Integer getPriorPermit() {
        return priorPermit;
    }

    public void setPriorPermit(Integer priorPermit) {
        this.priorPermit = priorPermit;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
