package com.one.aim.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.aim.bo.AdminBO;
import com.one.aim.constants.ErrorCodes;
import com.one.aim.constants.MessageCodes;
import com.one.aim.helper.AdminHelper;
import com.one.aim.mapper.AdminMapper;
import com.one.aim.repo.AdminRepo;
import com.one.aim.rq.AdminRq;
import com.one.aim.rs.AdminRs;
import com.one.aim.rs.data.AdminDataRs;
import com.one.aim.service.AdminService;
import com.one.constants.StringConstants;
import com.one.utils.Utils;
import com.one.vm.core.BaseRs;
import com.one.vm.utils.ResponseUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo adminRepo;

	// Sign Up
	@Override
	public BaseRs saveAdmin(AdminRq rq) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("Executing saveCompany(CompanyRq) ->");
		}

		List<String> errors = AdminHelper.validateAdmin(rq);

		if (Utils.isNotEmpty(errors)) {
			log.error(ErrorCodes.EC_INVALID_INPUT);
			return ResponseUtils.failure(ErrorCodes.EC_INVALID_INPUT, errors);
		}
		String docId = Utils.getValidString(rq.getDocId());
		String message = StringConstants.EMPTY;
		AdminBO adminBO = null;
		if (Utils.isNotEmpty(docId)) { // UPDATE
			long id = Long.parseLong(docId);
			Optional<AdminBO> optAdminBO = adminRepo.findById(id);
			adminBO = optAdminBO.get();
			if (adminBO == null) {
				log.error(ErrorCodes.EC_USER_NOT_FOUND);
				return ResponseUtils.failure(ErrorCodes.EC_USER_NOT_FOUND);
			}
		} else {
			adminBO = new AdminBO(); // SAVE
			message = MessageCodes.MC_SAVED_SUCCESSFUL;
		}
		String email = Utils.getValidString(rq.getEmail());
		if (!email.equals(Utils.getValidString(adminBO.getEmail()))) {
			adminBO.setEmail(email);
		}
		String userName = Utils.getValidString(rq.getUserName());
		if (!userName.equals(adminBO.getUsername())) {
			adminBO.setUsername(userName);
		}
		String phoneNo = Utils.getValidString(rq.getPhoneNo());
		if (!phoneNo.equals(adminBO.getPhoneno())) {
			adminBO.setPhoneno(phoneNo);
		}
		String password = Utils.getValidString(rq.getPassword());
		if (!password.equals(adminBO.getPassword())) {
			adminBO.setPassword(password);
		}
		adminRepo.save(adminBO);
		AdminRs adminRs = AdminMapper.mapToAdminRs(adminBO);
		return ResponseUtils.success(new AdminDataRs(message, adminRs));
	}
}

