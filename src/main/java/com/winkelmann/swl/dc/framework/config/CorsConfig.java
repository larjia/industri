package com.winkelmann.swl.dc.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域请求配置类
 * @author JiangL
 *
 */
@Configuration
public class CorsConfig
{
//	@Bean
//	public CorsFilter corsFilter()
//	{
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", buildConfig());
//		return new CorsFilter(source);
//	}
//	
//	private CorsConfiguration buildConfig()
//	{
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.addAllowedOrigin("*");
//		corsConfiguration.addAllowedHeader("*");
//		corsConfiguration.addAllowedMethod("*");
//		corsConfiguration.addExposedHeader("x-auth-token");
//		corsConfiguration.addExposedHeader("x-total-count");
//		return corsConfiguration;
//	}
}
