package com.matrimony.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matrimony.Entity.Admin;
import com.matrimony.Entity.Customer;
import com.matrimony.Exception.ResourceNotFoundException;
import com.matrimony.Repository.AdminRepository;
import com.matrimony.Repository.CustomerRepository;
import com.matrimony.Service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
private AdminRepository adminRepository;
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}


	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
		
	}


	@Override
	public List<Admin>getAllAdmins(){
		return adminRepository.findAll();
	}
	
	
	@Override
	public Admin getAdminById(long id) {
		
		return adminRepository.findById(id).orElseThrow(() ->
		                new ResourceNotFoundException("Admin","Id",id));
			
		}


	@Override
	public Admin updateAdmin(Admin admin, long id) { 
		Admin adm = adminRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Admin", "Id", id));
		
		adm.setUserName(admin.getUserName());
		adm.setPassword(admin.getPassword());
		
		adminRepository.save(adm);
		return adm;
	}
		
	

}
