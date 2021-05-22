package spring5_webmvc2_mybatis_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class, MvcConfig.class})
@ComponentScan(basePackages = {
	    "spring5_webmvc2_mybatis_study.service"
	  , "spring5_webmvc2_mybatis_study.controller"
		})
public class ContextRoot {
	
}