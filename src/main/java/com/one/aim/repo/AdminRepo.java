package com.one.aim.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.aim.bo.AdminBO;

@Repository
public interface AdminRepo extends JpaRepository<AdminBO, Long> {

}
