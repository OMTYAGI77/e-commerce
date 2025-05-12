package com.one.aim.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.aim.bo.CartBO;

@Repository
public interface CartRepo extends JpaRepository<CartBO, Long>{

}
