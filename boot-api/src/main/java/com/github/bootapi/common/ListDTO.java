/**
 * 
 */
package com.github.bootapi.common;

import java.util.List;

/*** <p>Title: ListDTO</p>
 * <p>Description: </p>
 */
public class ListDTO<T> extends CommonResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -227610636095724573L;
	
	List<T> data;

	public void setData(List<T> data) {
		this.data = data;
	}
	
	public List<T> getData() {
		return data;
	}

	public ListDTO() {
	}

	public ListDTO(int result) {
		super(result);
	}
	
	
	

}
