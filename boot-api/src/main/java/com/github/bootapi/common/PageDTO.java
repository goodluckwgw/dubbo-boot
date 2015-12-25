package com.github.bootapi.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*** <p>Title: PageDTO</p>
 * <p>Description:分页DTO对象 </p>
 */

public class PageDTO<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2008514627339493205L;
	
	private List<T> values;

	private Integer totalPage;

	private Integer totalElements;

	public PageDTO() {
	}

	public PageDTO(List<T> values) {
		this.values = values;
	}

	public PageDTO(final List<T> values, final Integer totalPage,
			final Integer totalElements) {
		this.values = values;
		this.totalElements = totalElements;
		this.totalPage = totalPage;
	}

	public List<T> getValues() {
		return values;
	}

	public void setValues(List<T> values) {
		this.values = values;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}


	@SuppressWarnings("unchecked")
	public static <T> PageDTO<T> EMPTY_PAGE(){
		return new PageDTO<T>(Collections.EMPTY_LIST, 0, 0);
	}
}