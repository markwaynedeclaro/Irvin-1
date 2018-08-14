package org.irvin.controller;

import java.util.List;

import javax.validation.Valid;

import org.irvin.dto.Level;
import org.irvin.exception.LevelNotFoundException;
import org.irvin.repository.LevelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LevelManagement")
public class LevelController {

	@Autowired
	LevelRepository levelRepository;
	
	// test
    @GetMapping("/test")
    public String test() {
    	System.out.println("here");
		return "here";
	}
    
	// Get All Levels
    @GetMapping("/levels")
    public List<Level> getAllLevels() {
		return levelRepository.findAll();
	}	
    
    // Create a new Level
    @PostMapping("/levels")
    public Level createLevel(@Valid @RequestBody Level level) {
        return levelRepository.save(level);
    }   
    
    // Get a Single Level
    @GetMapping("/levels/{id}")
    public Level getLevelById(@PathVariable(value = "id") String id) {
        return levelRepository.findById(id)
                .orElseThrow(() -> new LevelNotFoundException("id - "+id+" not found"));
    }   
    
    // Update a Level
    @PutMapping("/levels/{id}")
    public Level updateLevel(@PathVariable(value = "id") String id,
                                            @Valid @RequestBody Level levelDetails) {

    	Level level = levelRepository.findById(id)
                .orElseThrow(() -> new LevelNotFoundException("id - "+id+" not found"));

    	level.setLevel_desc(levelDetails.getLevel_desc());

    	Level updatedLevel = levelRepository.save(level);
        return updatedLevel;
    }    
    
    // Delete a Level
    @DeleteMapping("/levels/{id}")
    public ResponseEntity<?> deleteLevel(@PathVariable(value = "id") String id) {
    	Level level = levelRepository.findById(id)
                .orElseThrow(() -> new LevelNotFoundException("id - "+id+" not found"));

        levelRepository.delete(level);

        return ResponseEntity.ok().build();
    }    
    
  
}

