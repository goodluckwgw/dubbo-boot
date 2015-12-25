package com.github.bootapi.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BookDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2686557508260579473L;
	
	public Long id;
	public String bookId;
	public String title;
	public String url;
	public String status;

	public AccountDto owner;

	public Date onboardDate;

	public AccountDto borrower;

	public Date borrowDate;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
