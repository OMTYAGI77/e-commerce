package com.one.aim.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cart_table")
public class CartBO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String pname;
	
	@Column(name = "`desc`")
	private String desc;

	private long price;

	private String category;

	private boolean enabled = true;

	private int offer;

}
