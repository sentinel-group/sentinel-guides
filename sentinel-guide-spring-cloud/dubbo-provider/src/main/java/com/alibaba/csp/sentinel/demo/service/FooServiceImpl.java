package com.alibaba.csp.sentinel.demo.service;

import java.util.concurrent.ThreadLocalRandom;

import com.alibaba.csp.sentinel.demo.dubbo.FooService;
import com.alibaba.csp.sentinel.util.TimeUtil;

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
    public long getCurrentTime() {
        // Simulate slow invocations randomly.
        if (ThreadLocalRandom.current().nextInt(0, 100) > 70) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return TimeUtil.currentTimeMillis();
    }
}
