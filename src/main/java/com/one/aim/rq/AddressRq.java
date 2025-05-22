package com.one.aim.rq;

import com.one.aim.bo.UserBO;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressRq {
	
	    private String fullName;

	    private String street;

	    private String city;

	    private String state;

	    private String zip;

	    private String country;

	    private String phone;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id")
	    private UserBO user;
}
