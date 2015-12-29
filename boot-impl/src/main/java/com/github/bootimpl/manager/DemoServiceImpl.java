package com.github.bootimpl.manager;

import java.util.List;

import com.github.bootapi.api.DemoService;
import com.github.bootapi.dto.UserDto;



/**
 * DemoServiceImpl
 * 
 */
public class DemoServiceImpl implements DemoService {
    
    public String sayName(String name) {
        return "say:" + name;
    }

	@Override
	public List<UserDto> getUsers(List<UserDto> users) {
		return users;
	}
    
    
}