package com.mori.api;

import com.alibaba.fastjson.JSON;
import com.mori.api.core.listener.ApplicationEnvironmentPreparedEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Slf4j
@SpringBootApplication
public class CommonRestApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(CommonRestApplication.class);
    }
    public static void main(String[] args) {

        log.info("打印启动参数：{}", JSON.toJSONString(args));
        System.setProperty("file.encoding", "UTF-8");
        //class会重载，但不重启。与Tomcat的server.xml中的 reloadable="false" 效果一样
        SpringApplication application = new SpringApplication(CommonRestApplication.class);
        application.addListeners(new ApplicationEnvironmentPreparedEventListener());
        application.run(args);
      }

}
