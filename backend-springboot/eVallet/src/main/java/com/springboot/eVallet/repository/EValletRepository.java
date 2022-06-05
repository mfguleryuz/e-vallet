package com.springboot.eVallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.eVallet.entity.EVallet;

@Repository
public interface EValletRepository extends JpaRepository<EVallet, Long>{
	
	public boolean existsByCitizenId(String citizenId);
		
	@Query("select max(t.id) from EVallet t")
	public Integer findMaxId();

}
