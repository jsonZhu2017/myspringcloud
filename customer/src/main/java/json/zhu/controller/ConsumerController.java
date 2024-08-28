package json.zhu.controller;


import jakarta.servlet.http.HttpServletRequest;
import json.zhu.entity.StuInfo;
import json.zhu.feign.EchoFeignService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /*@Value("${stu.username}")
    private String username;

    @Value("${stu.age}")
    private Integer age;*/

    @Autowired
    private StuInfo stuInfo;


    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private EchoFeignService echoFeignService;

    private ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @GetMapping("/getStuInfo")
    public String getStuInfo(){
        /*StuInfo stuInfo = new StuInfo();
        stuInfo.setUsername(applicationContext.getEnvironment().getProperty("stu.username"));
        String age = applicationContext.getEnvironment().getProperty("stu.age");
        stuInfo.setAge(age == null? null:Integer.parseInt(age));

        StuInfo stuInfo2 = new StuInfo();*/
        return stuInfo.toString();
    }

    @GetMapping("/customer/{string}")
    public String echoAppName(@PathVariable String string){

        String url = String.format("http://provider/echo/%s", string);
        log.info("url:{}",url);

        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/customerFeign/{string}")
    public String echoAppNameFeign(@PathVariable String string){
        return echoFeignService.echo(string);
    }

    @RequestMapping(value = "/fun1")
    String fun1(@RequestParam String userId, @RequestParam String userName){
        return echoFeignService.fun1(userId,userName);
    }

    @PostMapping(value = "/fun2")
    String fun2(@RequestBody String requestBody){
        return echoFeignService.fun2(requestBody);
    }
}
