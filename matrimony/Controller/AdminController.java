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
import com.matrimony.Entity.Admin;
import com.matrimony.Exception.ResourceNotFoundException;
import com.matrimony.Repository.AdminRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("/getadmin")
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	// http://localhost:8080/api/v1/addadmin
	@PostMapping("/addadmin")
	public Admin createAdmin(@RequestBody Admin Admin) {
		return adminRepository.save(Admin);
	}

	// http://localhost:8080/api/v1/getadminbyid/11
	@GetMapping("/getadmin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id :" + id));
		return ResponseEntity.ok(admin);
	}

	// http://localhost:8080/api/v1/updateadmin/13
	@PutMapping("/updateadmin/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id :" + id));

		admin.setUserName(adminDetails.getUserName());
		admin.setPassword(adminDetails.getPassword());

		Admin updatedAdmin = adminRepository.save(admin);
		return ResponseEntity.ok(updatedAdmin);
	}

}
