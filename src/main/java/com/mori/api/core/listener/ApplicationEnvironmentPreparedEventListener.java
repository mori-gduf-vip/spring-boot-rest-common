package com.mori.api.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * 环境变量监听器 处理环境变量参数
 */
@Slf4j
@Component
public class ApplicationEnvironmentPreparedEventListener
		implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		ConfigurableEnvironment env = event.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		Iterator<PropertySource<?>> iterator = propertySources.iterator();
		while(iterator.hasNext()) {
			PropertySource<?> next = iterator.next();
			if(next instanceof SystemEnvironmentPropertySource) {
				SystemEnvironmentPropertySource systemEnv = (SystemEnvironmentPropertySource)next;
				String[] propertyNames = systemEnv.getPropertyNames();
				log.debug("打印环境变量名：" + propertyNames.toString());
			}
		}
		log.debug("打印环境变量：{}", env);
	}

}
