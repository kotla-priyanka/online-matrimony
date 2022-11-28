package com.matrimony;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.matrimony.Entity.Admin;
import com.matrimony.Entity.Customer;
import com.matrimony.Repository.AdminRepository;
import com.matrimony.Repository.CustomerRepository;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminTest {
	
	@Autowired
    public AdminRepository repo;

// post

   @Test
   @Order(1)
    public void testCreateAdmin() {
        Admin adm = new Admin();
        adm.setId(301l);
        adm.setUserName("anu");
        adm.setPassword("chris");
        Admin save = repo.save(adm);
        assertNotNull(save);
   }


 //get
   @Test
   @Order(2)
    public void testReadAll() {
        List<Admin> list = repo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
   
//getbyId
   
   @Test
   @Order(3)
    public void testgetId() {
        long id = 301l;
         Admin pay = repo.getById(id);
        assertThat(pay.getUserName()).isEqualTo(id);
    }

// put

   @Test
    @Order(4)
    public void testUpdate() {
        Admin adm = repo.findById(103l).get();
        adm.setUserName("anu");
        repo.save(adm);
        assertNotEquals("priya", repo.findById(103l).get().getUserName());
    }

   @Test

// delete

   @Order(5)
    public void testDelete() {
        repo.deleteById(103l);
        assertThat(repo.existsById(103l)).isFalse();
    }
   


}
