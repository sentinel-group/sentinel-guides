package com.alibaba.csp.sentinel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Run with the parameter:
 * {@code -Djava.net.preferIPv4Stack=true -Dcsp.sentinel.api.port=8727
 * -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=dubbo-provider}
 *
 * @author Eric Zhao
 */
@SpringBootApplication(scanBasePackages = "com.alibaba.csp.sentinel.demo.*")
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
