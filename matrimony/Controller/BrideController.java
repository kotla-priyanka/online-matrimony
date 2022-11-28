package com.matrimony.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.Entity.Bride;
import com.matrimony.Exception.ResourceNotFoundException;
import com.matrimony.Repository.BrideRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class BrideController {

	@Autowired
	private BrideRepository brideRepository;

	@GetMapping("/getbrides")
	public List<Bride> getAllBrides() {
		return brideRepository.findAll();
	}

	// http://localhost:8080/api/v1/addbrides
	@PostMapping("/addbrides")
	public Bride createBride(@RequestBody Bride bride) {
		return brideRepository.save(bride);
	}

	// http://localhost:8080/api/v1/getbridebyid/11
	@GetMapping("/getbrides/{id}")
	public ResponseEntity<Bride> getBrideById(@PathVariable Long id) {
		Bride bride = brideRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bride not exist with id :" + id));
		return ResponseEntity.ok(bride);
	}

	// http://localhost:8080/api/v1/updatebrides/13
	@PutMapping("/updatebrides/{id}")
	public ResponseEntity<Bride> updateBride(@PathVariable Long id, @RequestBody Bride brideDetails) {
		Bride bride = brideRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bride not exist with id :" + id));

		bride.setFirstName(brideDetails.getFirstName());
		bride.setLastName(brideDetails.getLastName());
		bride.setPassword(brideDetails.getPassword());
		bride.setEmailId(brideDetails.getEmailId());
		bride.setCaste(brideDetails.getCaste());
		bride.setReligion(brideDetails.getReligion());
		bride.setEducation(brideDetails.getEducation());
		bride.setLanguage(brideDetails.getLanguage());
		bride.setLocation(brideDetails.getLocation());
		bride.setGender(brideDetails.getGender());
		bride.setHeight(brideDetails.getHeight());
		bride.setWeight(brideDetails.getWeight());
		bride.setProfession(brideDetails.getProfession());
		bride.setCountry(brideDetails.getCountry());
		bride.setPlans(brideDetails.getPlans());

		Bride updatedBride = brideRepository.save(bride);
		return ResponseEntity.ok(updatedBride);
	}

}