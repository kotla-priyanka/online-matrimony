package com.matrimony.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.Entity.Bride;


@Repository
public interface BrideRepository extends JpaRepository<Bride, Long>{

}
