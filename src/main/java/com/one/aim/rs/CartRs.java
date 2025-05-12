package com.one.aim.rs;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartRs implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String docId;

	private String pName;

	private String desc;

	private long price;

	private String category;

	private boolean enabled = true;

	private int offer;

}
