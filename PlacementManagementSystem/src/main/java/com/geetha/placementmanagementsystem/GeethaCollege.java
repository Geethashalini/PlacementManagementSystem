package com.geetha.placementmanagementsystem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents the GeethaCollege entity, mapped to the "college" table.
 */
@Entity
@Table(name = "college")
public class GeethaCollege {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer collegeId;  // College ID (Primary Key)
    
    private String collegeName;  // College Name
    private String location;     // College Location
    
    /**
     * Default constructor.
     */
    public GeethaCollege() {
        super();
    }
    
    /**
     * Parameterized constructor to initialize a GeethaCollege instance.
     *
     * @param collegeId   The ID of the college.
     * @param collegeName The name of the college.
     * @param location    The location of the college.
     */
    public GeethaCollege(Integer collegeId, String collegeName, String location) {
        super();
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.location = location;
    }

    /**
     * Gets the college ID.
     *
     * @return The ID of the college.
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * Sets the college ID.
     *
     * @param collegeId The new ID of the college.
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * Gets the college name.
     *
     * @return The name of the college.
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * Sets the college name.
     *
     * @param collegeName The new name of the college.
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * Gets the location of the college.
     *
     * @return The location of the college.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the college.
     *
     * @param location The new location of the college.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     * Provides a string representation of the GeethaCollege object.
     *
     * @return A string describing the GeethaCollege object.
     */
    @Override
    public String toString() {
        return "GeethaCollege [collegeId=" + collegeId + ", collegeName=" + collegeName + ", location=" + location + "]";
    }
}
