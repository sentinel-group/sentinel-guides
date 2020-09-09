package com.alibaba.csp.sentinel.demo.service;

import com.alibaba.csp.sentinel.demo.dubbo.FooService;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author Eric Zhao
 */
@Service
public class FooServiceImpl implements FooService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @Override
    public long getCurrentTime(boolean slow) {
        // Simulate slow invocations randomly.
        if (slow) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {
            }
        }
        return System.currentTimeMillis();
    }
}
