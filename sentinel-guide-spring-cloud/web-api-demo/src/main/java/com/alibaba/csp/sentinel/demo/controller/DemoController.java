package com.alibaba.csp.sentinel.demo.controller;

import com.alibaba.csp.sentinel.demo.dubbo.FooService;
import com.alibaba.csp.sentinel.slots.block.SentinelRpcException;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric Zhao
 */
@RestController
@RequestMapping("/demo")
@DubboComponentScan
public class DemoController {

    @Reference(url = "dubbo://127.0.0.1:25758", timeout = 3000)
    private FooService fooService;

    @GetMapping("/hello")
    public String apiSayHello(@RequestParam String name) {
        try {
            return fooService.sayHello(name);
        } catch (SentinelRpcException e) {
            e.getCause().printStackTrace();
            return "oops, blocked by Sentinel...";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "oops...";
        }
    }

    @GetMapping("/time")
    public long apiCurrentTime() {
        try {
            return fooService.getCurrentTime();
        } catch (SentinelRpcException e) {
            e.getCause().printStackTrace();
            return -2;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}
