package com.matrimony.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
