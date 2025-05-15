package com.one.aim.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.aim.bo.CartBO;

public interface CartRepo extends JpaRepository<CartBO, Long>{
	
	List<CartBO> findByUserId(Long userId);

}
