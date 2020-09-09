package com.alibaba.csp.sentinel.demo.controller;

import com.alibaba.csp.sentinel.demo.dubbo.FooService;
import com.alibaba.csp.sentinel.demo.service.DemoService;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    public String apiSayHello(@RequestParam String name) {
        return fooService.sayHello(name);
    }

    @GetMapping("/bonjour")
    public String apiSayHelloLocal(@RequestParam String name) {
        return demoService.bonjour(name);
    }

    @GetMapping("/time")
    public long apiCurrentTime(@RequestParam(value = "slow", defaultValue = "false") Boolean slow) {
        return fooService.getCurrentTime(slow);
    }
}
