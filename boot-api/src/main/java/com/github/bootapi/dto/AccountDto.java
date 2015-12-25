package com.github.bootapi.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AccountDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2342013622672423549L;
	
	public Long id;
	public String email;
	public String name;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
