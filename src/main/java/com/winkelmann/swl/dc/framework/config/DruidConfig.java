package com.winkelmann.swl.dc.framework.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.winkelmann.swl.dc.common.utils.spring.SpringUtils;
import com.winkelmann.swl.dc.framework.config.properties.DruidProperties;

/**
 * druid配置多数据源
 * @author Administrator
 *
 */
@Configuration
public class DruidConfig
{
	@Bean
	@ConfigurationProperties("spring.datasource.druid.master")
	public DataSource masterDataSource(DruidProperties druidProperties)
	{
		DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
		return druidProperties.dataSource(dataSource);
	}
	
	@Bean
	@ConfigurationProperties("spring.datasource.druid.slave")
	@ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enabled", havingValue = "true")
	public DataSource slaveDataSource(DruidProperties druidProperties)
	{
		DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
		return druidProperties.dataSource(dataSource);
	}
	
	/**
   * 设置数据源
   * 
   * @param targetDataSources 备选数据源集合
   * @param sourceName 数据源名称
   * @param beanName bean名称
   */
  public void setDataSource(Map<Object, Object> targetDataSources, String sourceName, String beanName)
  {
      try
      {
          DataSource dataSource = SpringUtils.getBean(beanName);
          targetDataSources.put(sourceName, dataSource);
      }
      catch (Exception e)
      {
      }
  }
}
