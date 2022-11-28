package com.matrimony;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	
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
    import com.matrimony.Repository.CustomerRepository;



	@SpringBootTest
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class CustomerTest {



	   @Autowired
	    public CustomerRepository repo;

	// post

	   @Test
	   @Order(1)
	    public void testCreateCustomer() {
	        Customer cus = new Customer();
	        cus.setId(3);
	        cus.setFirstName("anu");
	        cus.setLastName("chris");
	        cus.setPassword("gfhdj");
	        cus.setEmailId("anu@gmail.com");
	        cus.setPhoneNo(9956473322L);
	        cus.setCaste("ghj");
	        cus.setReligion("chiristian");
	        cus.setEducation("B.tech");
	        cus.setLanguage("Tamil");
	        cus.setLocation("Vadalur");
	        cus.setGender("female");
	        cus.setHeight(5.1f);
	        cus.setWeight(60f);
	        cus.setProfession("Software Analyst");
	        cus.setCountry("India");
	        cus.setPlans("3months");
	        cus.setMaritalStatus("Single");
	        
	        Customer save = repo.save(cus);
	        assertNotNull(save);
	   }


	 //get
	   @Test
	   @Order(2)
	    public void testReadAll() {
	        List<Customer> list = repo.findAll();
	        assertThat(list).size().isGreaterThan(0);
	    }
	   
//getbyId
	   
	   @Test
       @Order(3)
	    public void testgetId() {
	        long id = 7;
	         Customer cus = repo.getById(id);
	        assertThat(cus.getFirstName()).isEqualTo(id);
	    }

	// put

	   @Test
	    @Order(4)
	    public void testUpdate() {
	        Customer cus = repo.findById(7l).get();
	        cus.setFirstName("anu");
	        repo.save(cus);
	        assertNotEquals("priya", repo.findById(7l).get().getFirstName());
	    }
	
	   @Test

	// delete

	   @Order(5)
	    public void testDelete() {
	        repo.deleteById(7l);
	        assertThat(repo.existsById(7l)).isFalse();
	    }
	   

	}
