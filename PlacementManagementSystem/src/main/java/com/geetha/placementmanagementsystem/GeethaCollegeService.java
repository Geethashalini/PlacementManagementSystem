package com.geetha.placementmanagementsystem;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * Service class for handling business logic related to GeethaCollege entity.
 */
@Service
@Transactional
public class GeethaCollegeService {

    @Autowired
    private GeethaCollegeRepository repo;

    /**
     * Retrieve all GeethaCollege records.
     *
     * @return A list of all GeethaCollege records.
     */
    public List<GeethaCollege> listAll() {
        return repo.findAll();
    }

    /**
     * Create a new GeethaCollege record or update an existing one.
     *
     * @param college The GeethaCollege object to be created or updated.
     */
    public void create(GeethaCollege college) {
        repo.save(college);
    }

    /**
     * Retrieve a specific GeethaCollege record by its ID.
     *
     * @param collegeId The ID of the college to retrieve.
     * @return The requested GeethaCollege object.
     * @throws NoSuchElementException If no college with the specified ID is found.
     */
    public GeethaCollege retrieve(Integer collegeId) {
        return repo.findById(collegeId).orElseThrow(() -> new NoSuchElementException("College not found"));
    }

    /**
     * Delete a specific GeethaCollege record by its ID.
     *
     * @param collegeId The ID of the college to delete.
     */
    public void delete(Integer collegeId) {
        repo.deleteById(collegeId);
    }
}
