package com.matrimony.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.Entity.Groom;


@Repository
public interface GroomRepository extends JpaRepository<Groom, Long>{

}
