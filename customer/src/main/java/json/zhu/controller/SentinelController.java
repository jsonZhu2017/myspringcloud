package json.zhu.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

public class SentinelController {


    @SentinelResource(value = "getUser",blockHandler = "handleException")
    public String sayHello(){
        return "Hello Sentinel!";
    }
}
