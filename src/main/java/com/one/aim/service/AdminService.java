package com.one.aim.service;

import com.one.aim.rq.AdminRq;
import com.one.vm.core.BaseRs;

public interface AdminService {
	
	public BaseRs saveAdmin(AdminRq rq) throws Exception;

}
