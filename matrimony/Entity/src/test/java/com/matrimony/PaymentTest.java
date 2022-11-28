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

import com.matrimony.Entity.Customer;
import com.matrimony.Entity.Payment;
import com.matrimony.Repository.PaymentRepository;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaymentTest {
	
	   @Autowired
	    public PaymentRepository repo;

	// post

	   @Test
	   @Order(1)
	    public void testCreatePayment() {
	        Payment pay = new Payment();
	        pay.setId(104);
	        pay.setName("anu");
	        pay.setBankName("axis");
	        pay.setAccNo("648725642");
	        pay.setAmount("10000");
	     
	        
	        Payment save = repo.save(pay);
	        assertNotNull(save);
	   }

	 //get
	   @Test
	   @Order(2)
	    public void testReadAll() {
	        List<Payment> list = repo.findAll();
	        assertThat(list).size().isGreaterThan(0);
	    }
	   
//getbyId
	   
	   @Test
       @Order(3)
	    public void testgetId() {
	        long id = 103;
	         Payment pay = repo.getById(id);
	        assertThat(pay.getName()).isEqualTo(id);
	    }

	// put

	   @Test
	    @Order(4)
	    public void testUpdate() {
	        Payment pay = repo.findById(103l).get();
	        pay.setName("anu");
	        repo.save(pay);
	        assertNotEquals("priya", repo.findById(103l).get().getName());
	    }
	
	   @Test

	// delete

	   @Order(5)
	    public void testDelete() {
	        repo.deleteById(103l);
	        assertThat(repo.existsById(103l)).isFalse();
	    }
	   

}
