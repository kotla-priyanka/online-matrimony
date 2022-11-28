package com.matrimony.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.matrimony.Entity.Payment;
import com.matrimony.Exception.ResourceNotFoundException;
import com.matrimony.Repository.PaymentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;

	@GetMapping("/getpayments")
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	// http://localhost:8080/api/v1/addpayments
	@PostMapping("/addpayments")
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentRepository.save(payment);
	}

	// http://localhost:8080/api/v1/getpaymentbyid/11
	@GetMapping("/getpayments/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id :" + id));
		return ResponseEntity.ok(payment);
	}

	// http://localhost:8080/api/v1/updatepayments/13
	@PutMapping("/updatepayments/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id :" + id));

		payment.setName(paymentDetails.getName());
		payment.setBankName(paymentDetails.getBankName());
		payment.setAccNo(paymentDetails.getAccNo());
		payment.setIfscCode(paymentDetails.getIfscCode());
		payment.setAmount(paymentDetails.getAmount());

		Payment updatedPayment = paymentRepository.save(payment);
		return ResponseEntity.ok(updatedPayment);
	}

	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Payment> deletePayment(@PathVariable Long id) {
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id :" + id));

		paymentRepository.delete(payment);
		return ResponseEntity.ok(payment);

	}

}