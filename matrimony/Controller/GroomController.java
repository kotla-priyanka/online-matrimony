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
import com.matrimony.Entity.Groom;
import com.matrimony.Exception.ResourceNotFoundException;
import com.matrimony.Repository.GroomRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class GroomController {

	
		@Autowired
		private GroomRepository groomRepository;
		
		
		@GetMapping("/searchgrooms")
		public List<Groom> getAllGrooms(){
			return groomRepository.findAll();
		}	
		
		
		
		//http://localhost:8080/api/v1/addgrooms
		@PostMapping("/addgrooms")
		public Groom createGroom(@RequestBody Groom groom) {
			return groomRepository.save(groom);
		}
		
		
		//http://localhost:8080/api/v1/getgroom/11
		@GetMapping("/searchgrooms/{id}")
		public ResponseEntity<Groom> getGroomById(@PathVariable Long id) {
			Groom groom = groomRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Groom not exist with id :" + id));
			return ResponseEntity.ok(groom);
		}
		
		
		//http://localhost:8080/api/v1/updategrooms/13
		@PutMapping("/updategrooms/{id}")
		public ResponseEntity<Groom> updateGroom(@PathVariable Long id, @RequestBody Groom groomDetails){
			Groom groom = groomRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Groom not exist with id :" + id));
			
			groom.setFirstName(groomDetails.getFirstName());
			groom.setLastName(groomDetails.getLastName());
			groom.setPassword(groomDetails.getPassword());
			groom.setEmailId(groomDetails.getEmailId());
			groom.setCaste(groomDetails.getCaste());
			groom.setReligion(groomDetails.getReligion());
			groom.setEducation(groomDetails.getEducation());
			groom.setLanguage(groomDetails.getLanguage());
			groom.setLocation(groomDetails.getLocation());
			groom.setGender(groomDetails.getGender());
			groom.setHeight(groomDetails.getHeight());
			groom.setWeight(groomDetails.getWeight());
			groom.setProfession(groomDetails.getProfession());
			groom.setCountry(groomDetails.getCountry());
			groom.setPlans(groomDetails.getPlans());
			
			Groom updatedGroom = groomRepository.save(groom);
			return ResponseEntity.ok(updatedGroom);
		}
		
}
