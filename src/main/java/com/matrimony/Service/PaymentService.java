package com.matrimony.Service;

import java.util.List;

import com.matrimony.Entity.Payment;

public interface PaymentService {

	Payment savePayment(Payment payment);

	List<Payment> getAllPayments();

	Payment getPaymentById(long id);

	Payment updatePayment(Payment payment, long id);

	void deletePayment(long id);

}
