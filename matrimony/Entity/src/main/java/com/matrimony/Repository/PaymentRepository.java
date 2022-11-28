package com.matrimony.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.Entity.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
