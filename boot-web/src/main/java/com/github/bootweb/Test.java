package com.github.bootweb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.github.bootapi.api.BarService;
import com.github.bootapi.dto.AccountDto;

public class Test {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/dubbo-service.xml");
		GenericService barService = (GenericService) context.getBean("barService");
		Object result = barService.$invoke("sayHello", new String[] { "java.lang.String" }, new Object[] { "World" });
		System.out.println(result);
		System.out.println("----------------------------------------------");
		
		// 用Map表示POJO参数，如果返回值为POJO也将自动转成Map 
		Map<String, Object> person = new HashMap<String, Object>(); 
		person.put("id", "123"); 
		person.put("email", "56@qq.com"); 
		person.put("name", "good"); 
		 result = barService.$invoke("findPerson", new String[]{"com.github.bootapi.dto.AccountDto"}, new Object[]{person}); // 如果返回POJO将自动转成Map
			System.out.println(result instanceof AccountDto);
			
	}

}
