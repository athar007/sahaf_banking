package com.sahafbanking.main.thymeleaf;

import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import nz.net.ultraq.thymeleaf.layoutdialect.decorators.strategies.GroupingStrategy;

@Configuration
public class ThymeleafCofiguration {
	
	
	public SpringTemplateEngine thymeleafLayoutDialect() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new LayoutDialect());
		engine.addDialect(new LayoutDialect(new GroupingStrategy()));
		return engine;
	}

}
