package com.one.aim.service;

import com.one.aim.rq.PaymentRq;
import com.one.vm.core.BaseRs;

public interface PaymentService {

	public BaseRs processPayment(PaymentRq rq) throws Exception;

}
