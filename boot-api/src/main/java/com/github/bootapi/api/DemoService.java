/**
 * 
 */
package com.github.bootapi.api;

import java.util.List;

import com.github.bootapi.dto.UserDto;

/** <p>Title: DemoService</p>
 * <p>Description: </p>
 * <p>Company: chinasi</p> 
 * @author wgw
 * @date 2015-12-29 下午5:07:27
 */
public interface DemoService {
	
	 String sayName(String name);
	 
	 List<UserDto> getUsers(List<UserDto> users);

}
