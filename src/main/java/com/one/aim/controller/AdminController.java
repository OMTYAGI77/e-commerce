package com.one.aim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.aim.rq.AdminRq;
import com.one.aim.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/admin/signup")
	public ResponseEntity<?> saveAdmin(@RequestBody AdminRq rq) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("Executing RESTfulService [POST /user]");
		}
		return new ResponseEntity<>(adminService.saveAdmin(rq), HttpStatus.OK);
	}
}
