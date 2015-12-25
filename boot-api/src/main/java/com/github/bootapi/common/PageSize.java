/**
 * 
 */
package com.github.bootapi.common;

import java.io.Serializable;

/*** <p>Title: PageSize</p>
 */
//@Deprecated
public class PageSize implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3357010489267880840L;
	
	
	private static final Integer DEFAULT_PAGE_NO = 1;
	private static final Integer DEFAULT_PAGE_SIZE = 4;

	Integer pageNo;

	Integer pageSize;
	
	/**
	 * 分页开始值
	 */
	private Integer pageOffset;

	public PageSize() {
		this.pageNo = DEFAULT_PAGE_NO;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}

	public PageSize(Integer pageNo, Integer pageSize) {
		this.pageNo = checkValue(pageNo, DEFAULT_PAGE_NO);
		this.pageSize = checkValue(pageSize, DEFAULT_PAGE_SIZE);
	}

	private Integer checkValue(Integer value, Integer defaultValue) {
		if (value == null || value < 1) {
			return defaultValue;
		}
		return value;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = checkValue(pageNo, DEFAULT_PAGE_NO);
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = checkValue(pageSize, DEFAULT_PAGE_SIZE);
	}

	public Integer getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}
	
	


}
