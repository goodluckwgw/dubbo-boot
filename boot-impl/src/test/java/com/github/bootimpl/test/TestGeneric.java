/**
 * 
 */
package com.github.bootimpl.test;

import java.io.IOException;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.github.bootapi.api.DemoService;
import com.github.bootimpl.manager.DemoServiceImpl;

/** <p>Title: TestGeneric</p>
 * <p>Description: </p>
 * <p>Company: chinasi</p> 
 * @author wgw
 * @date 2015-12-29 下午5:10:04
 */
public class TestGeneric {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		
		ServiceConfig<DemoService> service = new ServiceConfig<DemoService>();
		service.setApplication(new ApplicationConfig("generic-provider"));
		service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
		service.setProtocol(new ProtocolConfig("dubbo", 29581));
		service.setInterface(DemoService.class.getName());
		service.setRef(new DemoServiceImpl());
		service.export();
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
