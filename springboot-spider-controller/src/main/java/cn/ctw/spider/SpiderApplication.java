package cn.ctw.spider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
@Configuration
public class SpiderApplication {

	public static void main(String[] args) {
		/** 创建SpringApplication */
		SpringApplication springApplication = new SpringApplication(SpiderApplication.class);
		/** 设置横幅的模式 */
		/*springApplication.setBannerMode(Mode.OFF);*/
		/** 启动 */
		springApplication.run(args);
	}
}
