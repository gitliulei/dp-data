package net.astroway.yw.rrsdp;

import net.astroway.yw.base.sys.base.LoginInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by alex on 2017/1/24.
 */
//SpringBoot固定配置
@SpringBootApplication//采用微服务Feign让Interface代理Rest，被代理的Interface所在的package
@EnableFeignClients(basePackages = "net.astroway.yw.sys.api")//启动服务注册与服务发现，需要先有一个运行起来的注册中心（consul）
@EnableDiscoveryClient
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        return new WebMvcConfigurerAdapter() {
            //下边配置支持登录拦截，LoginInterceptor会拦截所有路径请求
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
            }
            //下面配置支持CORS，所有路径所有方法支持CORS请求
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*");
            }
        };
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

}
