package com.example.springhessianclient.config;

import com.example.springhessianclient.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@Configuration
public class HelloConfig {

    @Value("${hessian.hello.service.url}")
    private String serviceUrl;

    @Bean
    public HessianProxyFactoryBean helloServiceInvoker() {
        HessianProxyFactoryBean invoker = new HessianProxyFactoryBean();
        invoker.setServiceUrl(serviceUrl);
        invoker.setServiceInterface(HelloService.class);
        return invoker;
    }
}
