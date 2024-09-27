package com.geetha.placementmanagementsystem;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for managing GeethaCollege entity CRUD operations.
 */
@RestController
@RequestMapping("/college")
public class GeethaCollegeController {

    @Autowired
    private GeethaCollegeService service;

    /**
     * Create a new GeethaCollege record.
     *
     * @param college The GeethaCollege object to be created.
     * @return A success message indicating that the college has been created.
     */
    @PostMapping
    public ResponseEntity<String> add(@RequestBody GeethaCollege college) {
        service.create(college);
        return new ResponseEntity<>("College created successfully", HttpStatus.CREATED);
    }

    /**
     * Delete an existing GeethaCollege record by its ID.
     *
     * @param collegeId The ID of the college to be deleted.
     * @return A message indicating success or failure of the deletion.
     */
    @DeleteMapping("/{collegeId}")
    public ResponseEntity<String> remove(@PathVariable Integer collegeId) {
        try {
            service.delete(collegeId);
            return new ResponseEntity<>("College deleted successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("College not found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieve all GeethaCollege records.
     *
     * @return A list of all GeethaCollege records.
     */
    @GetMapping
    public ResponseEntity<List<GeethaCollege>> list() {
        List<GeethaCollege> colleges = service.listAll();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    /**
     * Retrieve a specific GeethaCollege record by its ID.
     *
     * @param collegeId The ID of the college to retrieve.
     * @return The requested GeethaCollege record, or 404 if not found.
     */
    @GetMapping("/{collegeId}")
    public ResponseEntity<GeethaCollege> get(@PathVariable Integer collegeId) {
        try {
            GeethaCollege college = service.retrieve(collegeId);
            return new ResponseEntity<>(college, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update an existing GeethaCollege record by its ID.
     *
     * @param college   The updated GeethaCollege object.
     * @param collegeId The ID of the college to update.
     * @return A message indicating success or failure of the update.
     */
    @PutMapping("/{collegeId}")
    public ResponseEntity<String> update(@RequestBody GeethaCollege college, @PathVariable Integer collegeId) {
        try {
            GeethaCollege existingCollege = service.retrieve(collegeId); // Check if record exists
            service.create(college);  // Reuse create method for simplicity
            return new ResponseEntity<>("College updated successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("College not found", HttpStatus.NOT_FOUND);
        }
    }
}

