package com.github.bootweb.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.github.bootapi.api.DemoService;

public class TestGeneric {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {

		ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
		reference.setApplication(new ApplicationConfig("generic-consumer"));
		reference.setInterface("com.github.bootapi.api.DemoService");
		reference.setProtocol("dubbo");
		reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
		reference.setGeneric(true);
		GenericService genericService = reference.get();
		try {
			
			Object result = genericService.$invoke("sayName", new String[] { "java.lang.String" }, new Object[] { "World" });
			System.out.println(result);
			System.out.println("----------------------------------------------");
			
			
			
			
			List<Map<String, Object>> users = new ArrayList<Map<String, Object>>();
			Map<String, Object> user = new HashMap<String, Object>();
			user.put("class", "com.github.bootapi.dto.UserDto");
			user.put("name", "provider");
			users.add(user);
			users = (List<Map<String, Object>>) genericService.$invoke(
					"getUsers", new String[] { List.class.getName() },
					new Object[] { users });
			System.out.println(users);

		} finally {
			reference.destroy();
		}

	}

}
