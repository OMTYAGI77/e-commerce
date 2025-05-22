package com.one.aim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.aim.bo.AddressBO;
import com.one.aim.bo.UserBO;
import com.one.aim.constants.ErrorCodes;
import com.one.aim.constants.MessageCodes;
import com.one.aim.helper.AddressHelper;
import com.one.aim.repo.AddressRepo;
import com.one.aim.repo.UserRepo;
import com.one.aim.rq.AddressRq;
import com.one.aim.rs.data.UserDataRs;
import com.one.aim.service.AddressService;
import com.one.utils.Utils;
import com.one.vm.core.BaseRs;
import com.one.vm.utils.ResponseUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Override
	public BaseRs saveAddress(AddressRq rq) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("Executing saveAddress(AddressRq) ->");
		}

		List<String> errors = AddressHelper.validateAddress(rq);

		if (Utils.isNotEmpty(errors)) {
			log.error(ErrorCodes.EC_INVALID_INPUT);
			return ResponseUtils.failure(ErrorCodes.EC_INVALID_INPUT, errors);
		}

		UserBO userBO = userRepo.findById(rq.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

		AddressBO address = new AddressBO();
		address.setFullName(rq.getFullName());
		address.setStreet(rq.getStreet());
		address.setCity(rq.getCity());
		address.setState(rq.getState());
		address.setZip(rq.getZip());
		address.setCountry(rq.getCountry());
		address.setPhone(rq.getPhone());
		address.setUser(userBO);
		addressRepo.save(address);
		String message = MessageCodes.MC_SAVED_SUCCESSFUL;
		return ResponseUtils.success(new UserDataRs(message));
	}

}
