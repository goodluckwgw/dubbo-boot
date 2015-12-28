package com.github.bootimpl.manager;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.github.bootapi.dto.AccountDto;

public class MyGenericService implements GenericService {

	@Override
	public Object $invoke(String method, String[] parameterTypes, Object[] args)
			throws GenericException {
		if ("sayHello".equals(method)) {
            return "Welcome " + args[0];
        }
		if ("findPerson".equals(method)) {
			AccountDto acc =  new AccountDto();
			acc.setId(1l);
			acc.setName("wgw");
			acc.setEmail("670688199@qq.com");
			return acc;
		}
		return method;
	}


}
