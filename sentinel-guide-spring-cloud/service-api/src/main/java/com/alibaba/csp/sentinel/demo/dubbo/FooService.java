package com.alibaba.csp.sentinel.demo.dubbo;

/**
 * @author Eric Zhao
 */
public interface FooService {

    String sayHello(String name);

    long getCurrentTime(boolean slow);
}
