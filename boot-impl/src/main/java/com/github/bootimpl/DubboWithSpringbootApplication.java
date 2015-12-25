package com.github.bootimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

/*@ComponentScan
// 组件扫描
@Configuration
// 配置控制
@EnableAutoConfiguration
// 启用自动配置
*/
@SpringBootApplication
@ImportResource({ "classpath:META-INF/spring/dubbo-service.xml" })
// 加入dubbo的bean的xml文件
public class DubboWithSpringbootApplication {

	private static final Logger logger = LoggerFactory
			.getLogger(DubboWithSpringbootApplication.class);

	private static volatile boolean running = true;

	public static void main(String[] args) throws Exception {
		// 启动Spring Boot项目的唯一入口
		 //设置dubbo使用slf4j来记录日志  
        System.setProperty("dubbo.application.logger","slf4j");  
		SpringApplication.run(DubboWithSpringbootApplication.class, args);
		logger.info("Dubbo spring boot started!");
		synchronized (DubboWithSpringbootApplication.class) {
			while (running) {
				try {
					DubboWithSpringbootApplication.class.wait();
				} catch (Throwable e) {
				}
			}
		}

	}

}
